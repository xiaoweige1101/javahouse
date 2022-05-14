package com.javahouse.nacos;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Properties;
import java.util.concurrent.Executor;

public class NacosTest {


    /**
     * Desc：获取Nacos配置
     * @throws Exception
     */
    @Test
    public void testGetNacosConfig() throws Exception {
        String serverAddr = "127.0.0.1:8848";
        String dataId = "nacos-simple-demo.yaml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                System.out.println("----getExecutor----");
                return null;
            }

            @Override
            public void receiveConfigInfo(String s) {
                System.out.println(s);
            }
        });

        while (true) {
            Thread.sleep(1000);
        }
    }


    @Test
    public void testCrypt() {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
    
    





}
