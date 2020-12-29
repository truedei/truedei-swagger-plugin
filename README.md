# 说明文档


## 一、项目介绍
> 此项目是对springfox-swagger2的一个功能上的扩展


pom.xml文件中，此处为什么要这样做：

```xml
    <!-- 引入swgger相关依赖       -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
            <exclusions>
                <exclusion>
                    <groupId>io.swagger</groupId>
                    <artifactId>swagger-models</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
            <version>1.5.21</version>
        </dependency>
```

原因：
> 因为在springfox-swagger2版本为2.9.2的依赖中，是依赖swagger-models版本为1.5.20的依赖的。
> 但是1.5.20的依赖是存在bug的，当访问swagger的时候，会出现：`DefaultValue for parameter type integer`类似的BUG


如下面博客中所提及到的：

https://blog.csdn.net/boyin333/article/details/87980108

《swagger2 Illegal DefaultValue for parameter type integer》
看了网上不少的解决方法

1、@ApiModelProperty(value = "主键", example = "123") ，太麻烦而且还是报错

2、修改jar源码，对于新手来说难度系数太大

经过一番思考，采用如下方案：使用pom的 exclusions方式

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.9.2</version>
    <exclusions>
        <exclusion>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-models</artifactId>
        </exclusion>
    </exclusions>
</dependency>
 
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-models</artifactId>
    <version>1.5.21</version>
</dependency>
```

排除swagger2本身引用的swagger-models-1.5.20.jar【这版本有bug】，引入更高的版本即可解决问题。





## 二、需要注意的事项

关于表格，一定要可以在某些工具中可以解析出来。

![image-20201222101425970](pic/image-20201222101425970.png)



否则就会报异常：

![image-20201222101505718](pic/image-20201222101505718.png)



## 三、功能列表
如何添加任务：
- [x] 1、 任务一 `- + 空格 + [ ]`
- [ ] 2、 任务二 `- + 空格 + [x]`

> 此处记录的功能不包括swagger已有的功能，只记录对其扩展的一些功能。

- [x] 1、 支持使用注解动态生成实体类（@Apicp & @ApiIgp）；
- [x] 2、 支持从文件中读取一些接口描述信息（@APiFileInfo）；
- [x] 3、 支持api分组（@ApiVersion）；
- [x] 4、 支持开启此扩展项目的开关的功能（@EnableSwaggerPlugin）；
- [ ] 5、 支持自定义UI；


