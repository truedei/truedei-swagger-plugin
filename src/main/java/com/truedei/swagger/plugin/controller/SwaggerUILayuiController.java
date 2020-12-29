package com.truedei.swagger.plugin.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

@Controller
@ApiIgnore //不让swagger扫描到这个接口
@CrossOrigin
public class SwaggerUILayuiController {

    @GetMapping("/apidoc.html")
    public String index(){
        System.out.println("访问了：gdoc，哈哈哈");
        return "apidoc";
    }

    @GetMapping("/gdoc")
    public String main(){
        return "index";
    }

}
