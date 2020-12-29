package com.truedei.swagger.plugin.io;

//import com.github.xiaoymin.knife4j.core.io.VFS;
import com.truedei.swagger.plugin.bean.APiFileInfoBean;

import java.io.*;
import java.util.*;


public class ResolverUtil {


  Map<String, Map<String, Object>> fileContentMap = new HashMap<>();

  List<String> fileContentList = new ArrayList<>();


  public Map<String, Map<String, Object>> getFileContentMap() {

    if(fileContentMap.size()==0){
      initFile(fileContentMap,fileContentList);
    }

    return fileContentMap;
  }

  public List<String> getFileContentList() {
    return fileContentList;
  }



  /**
   * 将Java包名转换为可以通过调用来查找的路径
   * @param packageName 包名，例如：com.truedei.controller
   * @return 返回：com/truedei/controller
   */
  protected String getPackagePath(String packageName) {
    return packageName == null ? null : packageName.replace('.', '/');
  }

  /**
   * 查找包下的资源
   * @param packageName
   * @return
   */
  public ResolverUtil find(String packageName) {
    //把com.truedei  形式的路径 变成：com/truedei
    String path = getPackagePath(packageName);

    try {

      List<String> children = VFS.getInstance().list(path);

      for (String child : children) {

        if (child.endsWith(".class")) {
          //组装成一个新的文件路径
          child = "/md"+child.substring(child.lastIndexOf('/')).replace("class","md");
          loadJarFileByFile(child);
        }

      }
    } catch (IOException ioe) {
      System.out.println("Could not read package: " + packageName+"-->"+ioe);
    }

    return this;
  }


  /**
   * 加载jar包的资源文件
   * @param file
   * @return
   */
  private  void  loadJarFileByFile(String file) {
//    System.out.println("----------loadJarFileByFile---- begin------------");
    InputStream stream = this.getClass().getResourceAsStream(file);

    if(stream==null){
      return ;
    }

    BufferedReader br = null ;
    try {
      br = new BufferedReader(new InputStreamReader(stream,"UTF-8")) ;
      String s=null ;
      while((s=br.readLine()) !=null){
//        System.out.println(s);
        fileContentList.add(s);
      }
      br.close();
    } catch (FileNotFoundException e) {

      System.out.println("FileNotFoundException:"+e);
    } catch (IOException e) {
      System.out.println("IOException :"+e);
    }finally {
      if(br !=null){
        try {
          br.close();
        } catch (IOException e) {
          System.out.println("close br error:"+e);
        }
      }
    }
//    System.out.println("----------loadJarFileByFile---- end------------\n\n");
  }




  /**
   *解析数据之
   *    一、锁定每一个api的起始位置（在文件中的）
   * @param map
   * @param fileContentList 把文件内容一次性读取到List集合中，减少之后对磁盘I/O的操作，方便之后解析和操
   */
  private  void initFile( Map<String, Map<String, Object>> map, List<String> fileContentList) {
    int start = 0;//一个api的描述的开始
    int end = 0;//一个api的描述的结束

    //操作每一行数据
    for (int i = 0; i < fileContentList.size(); i++) {
      String dataLine = fileContentList.get(i);

      //开头是# URL:号的 代表是一个URL的开始
      if(dataLine.startsWith("# URL:")){
        start = i;

        //找到当前这个API描述的 结束的位置
        for (int j = i+1;j<fileContentList.size();j++){
          String dataLine_start = fileContentList.get(j);
          if(dataLine_start.startsWith("# URL:")) {
            end = j-1;//记录结束的位置
            i=j-1;//i位置跳过整个流程
            break;
          }
        }

        //针对这个区间进行处理
        disposeInterval(start,end,fileContentList,map);
      }

    }

    //处理最后一组API的数据
    disposeInterval(start,fileContentList.size(),fileContentList,map);
  }

  /**
   * 二、处理这个api接口，区间的数据
   *
   * 处理这个区间的数据，区间指的是：
   * 从：```json
   *
   * ...代码
   *
   * 到：```
   * 代码块的区间
   *
   * @param start 从：```json的位置(在List中的位置)
   * @param end 到：```的位置
   * @param list 数据来源
   * @param map 把结果封装的集合
   */
  private  void disposeInterval(int start, int end, List<String> list,  Map<String, Map<String, Object>> map) {
    int code_start = 0;
    int code_end = 0;
    String flag = null;
    Boolean flag_miaoshu = false;

    StringBuilder sb = new StringBuilder();


    for (int index = start; index < end ; index++) {
      String s = list.get(index);

      //找到某个接口的flag
      if( flag == null && s.startsWith("# URL:")){
        flag = s.substring(6, s.length()).replace(" ","");
//                flag_miaoshu = true;
      }


      //找到接口描述的部分
      if( flag != null && flag_miaoshu==false){
//        System.out.println("正在解析的接口："+flag);

//                sb.append(s);
//                System.out.println(s);
//                System.out.println("接口描述开始位置:"+start);
        //找到结束的位置
        for (int i = index+1; i < end; i++) {
          s = list.get(i);
          //结束
          if(s.replace(" ","").endsWith("---") && s.replace(" ","").equals("---")) {
//            System.out.println("接口描述结束位置:"+(start+1)+"-->"+(i-1));
            chulijiekoumiaoshu(flag,list,(start+1),(i-1),map);
            flag_miaoshu=true;
            break;
          }
        }
      }


      //找出每个code的数据的开始和结束
      if( flag!=null && !"".equals(flag.trim()) &&
              s.replace(" ","").endsWith("---") &&
              s.replace(" ","").equals("---")){
        //记录开始的位置
        code_start = index+1+1;

        for (int i = index+1; i < end; i++) {
          s=list.get(i);
          //结束
          if(s.replace(" ","").endsWith("---") && s.replace(" ","").equals("---")) {
            //记录结束位置
            code_end = i-1;
            //跳过这个区间的代码
            index = i-1;
//            System.out.println("code起始位置："+code_start+"--->"+code_end);
//                        System.out.println("接口描述位置："+(start+1)+"-->"+(code_start-2-1));

            //处理这个code的区间的数据
            disposeCodeInterval(flag,code_start,code_end,list,map);

            //清空
            sb.delete(0,sb.length());

            break;
          }
        }
      }


    }
  }

  private  void chulijiekoumiaoshu(String flag, List<String> list, int start, int end,  Map<String, Map<String, Object>> map) {

    //存储接口描述的数据
    StringBuilder miaoshu_body = new StringBuilder();

//    System.out.println("接口文档开始：");
    for (int j = start; j < end; j++) {
//      System.out.println(list.get(j));
      miaoshu_body.append(list.get(j)+"\r\n");
    }
//    System.out.println("接口文档结束");

    Map<String, Object> map1 = map.get(flag);
    if(map1 == null){
      map1 = new HashMap<>();
      map1.put("miaoshu",miaoshu_body);
      map.put(flag,map1);
    }

  }

  /**
   * 处理code区间的数据
   * @param flag
   * @param code_start
   * @param code_end
   * @param list
   * @param map
   */
  private  void disposeCodeInterval(String flag, int code_start, int code_end, List<String> list,  Map<String, Map<String, Object>> map) {
    APiFileInfoBean aPiFileInfoBean = new APiFileInfoBean();

    StringBuilder sb = new StringBuilder();

    //存储 ```json  ```代码块
    StringBuilder code_body = new StringBuilder();

    for (int index = code_start; index <= code_end ; index++) {
      String s = list.get(index);
      if(s.startsWith("code:")){
        String code = s.substring(5, s.length());
        try {//防止code不是数字
          aPiFileInfoBean.setCode(Integer.valueOf(code.replace(" ","")));
        }catch (Exception e){
          e.fillInStackTrace();
        }

      }else if(s!=null && !(s.replace(" ","")).equals("") ){
        //code body start  ```开始
        if(s.charAt(0)=='`' && s.charAt(1)=='`' && s.charAt(2)=='`'){

          code_body.append(s+"\n");
          sb.append(s+"\n");

          for (int i = index+1; i < list.size() ; i++) {
            s = list.get(i);
            sb.append(list.get(i)+"\n");
            code_body.append(list.get(i)+"\n");
            if(s!=null && !(s.replace(" ","").equals("")) &&s.charAt(0)=='`' && s.charAt(1)=='`' && s.charAt(2)=='`'){
              index=i;
              break;
            }
          }


        }else{
          sb.append(s+"\n");
        }
      }else{
        sb.append(list.get(index)+"\n");
      }
    }

    aPiFileInfoBean.setMessage(sb.toString());

    if(flag!=null && !flag.equals("") && aPiFileInfoBean!=null && aPiFileInfoBean.getCode() != null){

      Map<Integer, APiFileInfoBean> codesMap = new HashMap<>();
      codesMap.put(aPiFileInfoBean.getCode(),aPiFileInfoBean);

      //每个类型的Map
      Map<String, Object> typeMap = map.get(flag);
      if(typeMap!=null && typeMap.get("codes")==null){
//                typeMap = new HashMap<>();
        typeMap.put("codes",codesMap);
      }else{
        //如果已经存在就获取已经存在的
        Object codes = typeMap.get("codes");
        if(codes!=null){
          Map<Integer, APiFileInfoBean> codeMap = (Map<Integer, APiFileInfoBean>)codes;

          for (Map.Entry<Integer, APiFileInfoBean> entry : codeMap.entrySet()) {
            codesMap.put(entry.getKey(), entry.getValue());
          }

          //都添加进去
          typeMap.put("codes",codesMap);
        }

      }

      map.put(flag,typeMap);
    }
  }

}
