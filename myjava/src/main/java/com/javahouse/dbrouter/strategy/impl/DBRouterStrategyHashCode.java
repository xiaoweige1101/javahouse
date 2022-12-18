package com.javahouse.dbrouter.strategy.impl;

import com.javahouse.dbrouter.DBRouterConfig;
import com.javahouse.dbrouter.strategy.IDBRouterStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:51
 */
public class DBRouterStrategyHashCode implements IDBRouterStrategy {

    private Logger logger = LoggerFactory.getLogger(DBRouterStrategyHashCode.class);

    private DBRouterConfig dbRouterConfig;

    public DBRouterStrategyHashCode(DBRouterConfig dbRouterConfig) {
        this.dbRouterConfig = dbRouterConfig;
    }


    @Override
    public void doRouter(String dbKeyAttr) {
        int size = dbRouterConfig.getDB

    }

    @Override
    public void setDBKey(int dbIdx) {

    }

    @Override
    public void setTBKey(int tbIdx) {

    }

    @Override
    public int dbCount() {
        return 0;
    }

    @Override
    public int tbCount() {
        return 0;
    }

    @Override
    public void clear() {

    }
}
