package com.javahouse.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/17 18:28
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
//        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, (a, b, c) -> {
            long startTimestamp = System.currentTimeMillis();
            Object result = b.invoke(proxiedObject, c);
            long endTimestamp = System.currentTimeMillis();
            metricsCollector = null;
            return result;
        });
    }

    private class DynamicProxyHandler implements InvocationHandler {

        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimestamp = System.currentTimeMillis();
            return result;
        }
    }


    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
    }

}
