package com.truedei.swagger.plugin.bean;

/**
 * @author zhenghui
 * @date 2020/12/22 21:16
 * @desc 作用：存放从文件中获取的必要信息
 */
public class APiFileInfoBean {

    private String url;

    private Integer code;

    private String message;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
