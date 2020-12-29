package com.truedei.swagger.plugin;

import com.truedei.swagger.plugin.util.MdToHtml;


public class MakdownTest {

    public static void main(String[] args) {

        String str = "## 请求header参数\n" +
                "\n" +
                "| 参数 | 参数类型 | 参数约束 | 是否必传 | 示例值 | 描述 |\n" +
                "| --- | --- | --- | --- | --- | --- |\n" +
                "| Authorization | 字符串 | 从用户中心获取 | 是 | Bearer cn-236f6e4f-6db5-46c2-97ec-19b4f5d499d3 | 从用户中心获取的ACCESS_TOKEN |\n" +
                "| session-id | 字符串 | 服务端返回,可从以下api中获取: <br/> - [**开始新会话V3**](#sort=api&doc=robotAppOpenApi/servingApi/01-chatInit/01-init-chat-v3.md) <br/> - [**会话超时，重启会话V3**](#sort=api&doc=robotAppOpenApi/servingApi/01-chatInit/02-restart-chat-v3.md) | 否 | C3D205E1B4C72BF451CDC326328786A5 | 索引用户信息的key |\n" +
                "| openid | 字符串 | 客户端获取 | 否 | oAyxzxImtuhS2Oc1AQq-ObVVhXWg | 微信用户在该公众号的openId |";

        String str1 = "";

        System.out.println(MdToHtml.convert(str));

    }




}
