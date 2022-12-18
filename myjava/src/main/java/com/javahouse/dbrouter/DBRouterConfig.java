package com.javahouse.dbrouter;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:49
 */
public class DBRouterConfig {

    private int dbCount;

    private int tbCount;

    private String routerKey;

    public DBRouterConfig() {

    }

    public int getDbCount() {
        return dbCount;
    }

    public void setDbCount(int dbCount) {
        this.dbCount = dbCount;
    }

    public int getTbCount() {
        return tbCount;
    }

    public void setTbCount(int tbCount) {
        this.tbCount = tbCount;
    }

    public String getRouterKey() {
        return routerKey;
    }

    public void setRouterKey(String routerKey) {
        this.routerKey = routerKey;
    }
}
