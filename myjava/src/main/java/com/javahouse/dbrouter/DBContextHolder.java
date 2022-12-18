package com.javahouse.dbrouter;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:50
 */
public class DBContextHolder {

    private static final ThreadLocal<String> dbKey = new ThreadLocal<>();

    private static final ThreadLocal<String> tbKey = new ThreadLocal<>();

    public static void setDBKey(String dbKeyIdx) {
        dbKey.set(dbKeyIdx);
    }

    public static String getDbKey() {
        return dbKey.get();
    }

    public static void setTbKey(String tbKeyIdx) {
        tbKey.set(tbKeyIdx);
    }

    public static String getTbKey() {
        return tbKey.get();
    }

    public static void clearDBKey() {
        dbKey.remove();
    }

    public static void clearTBKey() {
        tbKey.remove();
    }

}
