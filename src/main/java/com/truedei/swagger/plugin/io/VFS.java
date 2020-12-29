/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.truedei.swagger.plugin.io;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


/**
 * Provides a very simple API for accessing resources within an application server.
 *
 * @author Ben Gunter
 */
public  class VFS {
  private static final Log log = LogFactory.getLog(VFS.class);

  private VFS(){

  }

  private static class VFSHolder{
    static final VFS instance = new VFS();
  }

  public static VFS getInstance(){
    return VFSHolder.instance;
  }

  /***
   * get Resources by path
   * @param path 扫描路径
   * @return 扫描集合URL
   * @throws IOException 文件异常
   */
  protected static List<URL> getResources(String path) throws IOException {
    return Collections.list(Thread.currentThread().getContextClassLoader().getResources(path));
  }


  /**
   * 根据URL查找path，并封装成list集合返回
   * @param url
   * @param path
   * @return
   * @throws IOException
   */
  public List<String> list(URL url,String path) throws IOException {
//    System.out.println("我来查list啦："+path);
//    System.out.println("我来查list啦 url ："+url.getPath());

    List<String> resources=new ArrayList<>();
    InputStream ins=null;
    //is jar
    try{
      URL jarUrl=findJarForResource(url);
      if (jarUrl!=null){
//        System.out.println("我是jar包哎，我已经被打开了，jarUrl!=null --->");
        ins=jarUrl.openStream();
        resources=listResources(new JarInputStream(ins),path);
//        System.out.println("我是jar包哎，我已经被打开了，resources --->"+resources);
      }else{
        List<String> children=new ArrayList<>();
        try{
          if (isJar(url)){
            ins=url.openStream();
            try(JarInputStream jarInputStream=new JarInputStream(ins)){
              for (JarEntry entry; (entry = jarInputStream.getNextJarEntry()) != null; ) {
                if (log.isDebugEnabled()) {
                  log.debug("Jar entry: " + entry.getName());
                }
                children.add(entry.getName());
              }
            }
          }else{
            ins=url.openStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(ins));
            List<String> lines = new ArrayList<>();
            for (String line; (line = reader.readLine()) != null;) {
              if (log.isDebugEnabled()) {
                log.debug("Reader entry: " + line);
              }
              lines.add(line);
              if (getResources(path + "/" + line).isEmpty()) {
                lines.clear();
                break;
              }
            }
            if (!lines.isEmpty()) {
              if (log.isDebugEnabled()) {
                log.debug("Listing " + url);
              }
              children.addAll(lines);
            }
          }
        }catch (FileNotFoundException ex){
          if ("file".equals(url.getProtocol())) {
            File file = new File(url.getFile());
            if (log.isDebugEnabled()) {
              log.debug("Listing directory " + file.getAbsolutePath());
            }
            if (file.isDirectory()) {
              if (log.isDebugEnabled()) {
                log.debug("Listing " + url);
              }
              children = Arrays.asList(file.list());
            }
          }
          else {
            // No idea where the exception came from so rethrow it
            throw ex;
          }
        }
        String prefix = url.toExternalForm();
        if (!prefix.endsWith("/")) {
          prefix = prefix + "/";
        }
        for (String child : children) {
          String resourcePath = path + "/" + child;
          resources.add(resourcePath);
          URL childUrl = new URL(prefix + child);
          resources.addAll(list(childUrl, resourcePath));
        }
      }
      return resources;
    }finally {
      if (ins != null) {
        try {
          ins.close();
        } catch (Exception e) {
        }
      }
    }
  }

  /**
   * 查找jar包中要查找的资源，并封装成一个List返回
   * @param jarInputStream jar包流
   * @param path 要查找的路径，例如：/com/glodon/controllers/
   * @return
   * @throws IOException
   */
  protected List<String> listResources(JarInputStream jarInputStream,String path) throws IOException {
//    System.out.println("我进到listResources啦啦啦啦-->");
//    System.out.println("进入了listResources-->要查找的path是--1-->："+path);

    if (!path.startsWith("/")){
      path="/"+path;
    }
    if (!path.endsWith("/")){
      path=path+"/";
    }

//    System.out.println("进入了listResources-->要查找的path是--2-->："+path);

    List<String> resources=new ArrayList<>();
    for (JarEntry entry;(entry= jarInputStream.getNextJarEntry())!=null;){
      if (!entry.isDirectory()){
        StringBuilder name=new StringBuilder(entry.getName());

//        System.out.println("listResources-->"+name);
        if (name.charAt(0)!='/'){
          name.insert(0,'/');
        }

        //当前的name中包含次路径，说明符合要查找的要求，就添加进去
        if (name.indexOf(path) > 0 ){
          resources.add(name.substring("/BOOT-INF/classes/".length(),name.length()));
        }

      }
    }
    return resources;
  }

  public URL findJarForResource(URL url){
    if (log.isDebugEnabled()){
      log.debug("Find JAR URL:"+url);
    }
    try {
      for (;;){
        url=new URL(url.getFile());
      }
    } catch (MalformedURLException e) {
    }
    StringBuffer jar=new StringBuffer(url.toExternalForm());

//    System.out.println("jar--->"+jar);

    int index=jar.lastIndexOf(".jar");
//    System.out.println("jar.lastIndexOf(\".jar\")--->"+index);

    if (index>=0){
      jar.setLength(index+4);
      if (log.isDebugEnabled()) {
        log.debug("Extracted JAR URL: " + jar);
      }
    }else{
      if (log.isDebugEnabled()){
        log.debug("Not a Jar:"+jar);
      }
      return null;
    }
    try{
      URL targetUrl=new URL(jar.toString());
      if (isJar(targetUrl)){
//        System.out.println("我是jar包资源，我要返回啦啦啦啦--->"+targetUrl);
        return targetUrl;
      }else{
        if (log.isDebugEnabled()){
          log.debug("Not a Jar:"+jar);
        }
        jar.replace(0,jar.length(),targetUrl.getFile());
        File file=new File(jar.toString());
        if (!file.exists()){
          try{
            file=new File(URLEncoder.encode(jar.toString(),"UTF-8"));
          }catch (UnsupportedEncodingException e){
            throw new RuntimeException("Unsupported encoding?  UTF-8?  That's unpossible.");
          }
        }
        if (file.exists()){
          if (log.isDebugEnabled()){
            log.debug("real File:"+file.getAbsolutePath());
          }
          targetUrl=file.toURI().toURL();
          if (isJar(targetUrl)){
            return targetUrl;
          }
        }
      }
    }catch (MalformedURLException e){
      log.warn("Invalid JAR URL: " + jar);
    }
    if (log.isDebugEnabled()) {
      log.debug("Not a JAR: " + jar);
    }
    return null;
  }


  private static final byte[] JAR_MAGIC = { 'P', 'K', 3, 4 };

  public boolean isJar(URL url){
    return isJar(url,new byte[JAR_MAGIC.length]);
  }

  private boolean isJar(URL url,byte[] buffer){
    InputStream ins=null;
    try{
      ins=url.openStream();
      ins.read(buffer,0,JAR_MAGIC.length);
      if (Arrays.equals(buffer,JAR_MAGIC)){
        if (log.isDebugEnabled()){
          log.debug("Found Jar:"+url);
        }
        return true;
      }
    }catch (Exception e){
      if (log.isDebugEnabled()){
        log.debug(e.getMessage(),e);
      }
    }finally {
      if (ins!=null){
        try {
          ins.close();
        } catch (IOException e) {
          //ignore
        }
      }
    }
    return false;
  }

  /**
   * Recursively list the full resource path of all the resources that are children of all the
   * resources found at the specified path.
   *
   * @param path The path of the resource(s) to list.
   * @return A list containing the names of the child resources.
   * @throws IOException If I/O errors occur
   */
  public List<String> list(String path) throws IOException {
    List<String> names = new ArrayList<>();
    for (URL url : getResources(path)) {
      names.addAll(list(url, path));
    }
    return names;
  }
}
