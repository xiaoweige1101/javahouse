package com.javahouse.dbrouter;

/**
 * @author wei.zhang
 * @desc
 * @date 2022/12/18 09:50
 */
public class DBRouterBase {

    private String tbIdx;

    public String getTbIdx() {
        return DBContextHolder.getTbKey();
    }


}
