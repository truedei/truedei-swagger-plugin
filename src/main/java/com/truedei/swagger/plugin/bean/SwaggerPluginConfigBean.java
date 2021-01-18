package com.truedei.swagger.plugin.bean;


/**
 * swagger plugin的配置信息
 */
public class SwaggerPluginConfigBean {


    /**
     * 是否开启debug模式，用于控制是否输出debug信息
     */
    private boolean debug;


    /**
     * 扫描的配置
     */
    private ScanBean scan;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public ScanBean getScan() {
        return scan;
    }

    public void setScan(ScanBean scan) {
        this.scan = scan;
    }
}
