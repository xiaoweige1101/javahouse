package com.javahouse.dbrouter.strategy;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:51
 */
public interface IDBRouterStrategy {

    void doRouter(String dbKeyAttr);

    void setDBKey(int dbIdx);

    void setTBKey(int tbIdx);

    int dbCount();

    int tbCount();

    void clear();

}
