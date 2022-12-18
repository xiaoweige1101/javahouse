package com.javahouse.dbrouter.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:03
 */
@Configuration
public class DataSourceAutoConfig implements EnvironmentAware {

    private Map<String, Map<String, Object>> dataSourceMap = new HashMap<>();

    private Map<String, Object> defaultDataSourceConfig;

    private int dbCount;

    private int tbCount;

    private String routerKey;





    @Override
    public void setEnvironment(Environment environment) {

    }
}
