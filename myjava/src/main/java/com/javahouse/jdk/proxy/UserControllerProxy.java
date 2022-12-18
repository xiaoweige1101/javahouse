package com.javahouse.jdk.proxy;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/17 18:42
 */
public class UserControllerProxy extends UserController {

    private MetricsCollector metricsCollector;

    public UserControllerProxy() {
        this.metricsCollector = new MetricsCollector();
    }




}
