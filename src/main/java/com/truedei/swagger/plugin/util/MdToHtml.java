package com.truedei.swagger.plugin.util;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.youbenzi.mdtool.tool.MDTool;
import java.util.*;


public class MdToHtml {
    /**
     * @param md makdown语法
     * @return html语法
     */
    public final static String makdownToHtml(String md) {
        StringBuilder mdBody = new StringBuilder();

        //遍历传递过来的md，查找到```xxx开头的 一直到```结尾的
        for (int i = 0; i < md.length() ; i++) {
            //重新构造一个```json  ```代码块
            StringBuilder newCodeBody = new StringBuilder();
            newCodeBody.append("\n\n");
            newCodeBody.append("<details> \n");
            newCodeBody.append("\n");
            newCodeBody.append("<summary>点击展开查看</summary> \n");

            //code body start  ```开始
            if(md.charAt(i)=='`' && md.charAt(i+1)=='`' && md.charAt(i+2)=='`'){

                String temp = md.substring(i+3);//开始分割```
                int strIndex = findStrIndex(temp);//查找```之后的代码类型例如：```java，```json等，查找结束的位置

                String codeType = md.substring(i + 3, i + 3 + strIndex);//保留代码的类型

                newCodeBody.append("\n```"+codeType+"\n");//重新合并类型

                //从代码块的类型开始例如：```json之后开始  +1：代码块类型之后的回车   ```结束
                for (int j = i+3+strIndex+1; j < md.length() ; j++) {
                    //code body end  遇到```代码块结束了
                    if(md.charAt(j)=='`' && md.charAt(j+1)=='`' && md.charAt(j+2)=='`'){
                        i=j+3; //让i跳过去```json  到```中的代码

                        //追加上```代码块的结尾
                        newCodeBody.append("\n```\n");

                        //追加上折叠代码块的结尾
                        newCodeBody.append("\n");
                        newCodeBody.append("</details>");
                        newCodeBody.append("\n");

                        break;//跳出本次循环 代表```json  此代码块 ```  结束了
                    }else{
                        //组合code body内的代码
                        newCodeBody.append(md.charAt(j));
                    }
                }

                //代码整合结束后，把整合后的代码追加到makdown的Body中
                mdBody.append(newCodeBody.toString());

            }else{
                //其他的代码一律直接追加到makdown body中
                mdBody.append(md.charAt(i));
            }
        }

        //makdown语法转换成html语法的工具
//        MutableDataSet options = new MutableDataSet();
//        Parser parser = Parser.builder(options).build();
//        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

//        // You can re-use parser and renderer instances
//        Node document = parser.parse(mdBody.toString());
//
//        //转换成html
//        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
//
//        return html;


        String html = MDTool.markdown2Html(mdBody.toString());
        //添加table的样式
        html = html.replace("<table>","<table border='1'>");
        return html;
    }

    static private int findStrIndex(String str){
        int sum = 0;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)=='\n')
                return sum++;
            else
                sum++;
        }
        return -1;
    }

    public final static String MdToHtml(String md) {
        MutableDataSet options = new MutableDataSet();


        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(md.toString());

        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"

        return html;
    }

    /**
     *  markdown格式装换成Html格式
     * @param markdown
     * @return
     */
    public static String markdownToHtml(String markdown){
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    //可以解析makdown表格成html表格的方法
    public static String convert(String markdown_content) {
        String html = MDTool.markdown2Html(markdown_content);
        //添加table的样式
        html = html.replace("<table>","<table border='1'>");
        return html;
    }


}
