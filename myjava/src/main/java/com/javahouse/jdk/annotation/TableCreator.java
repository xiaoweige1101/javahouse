package com.javahouse.jdk.annotation;

import com.javahouse.jdk.annotation.anno.Constraints;
import com.javahouse.jdk.annotation.anno.DBTable;
import com.javahouse.jdk.annotation.anno.SQLInteger;
import com.javahouse.jdk.annotation.anno.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {


    public static String createTableSql(String className) throws ClassNotFoundException {
        Class<?> cl = Class.forName(className);
        DBTable dbTable = cl.getAnnotation(DBTable.class);

        if (null == dbTable) {
            System.out.println("Not DBTable annotations in class " + className);
            return null;
        }

        String tableName = dbTable.name();

        // if the name is empty, use the class name
        if (tableName.length() < 1) {
            tableName = cl.getName().toUpperCase();
        }

        List<String> columnDefs = new ArrayList<String>();

        // 通过Class类API获取到所有成员字段
        for (Field field : cl.getDeclaredFields()) {
            String columnName = null;
            // 获取字段上的注解
            Annotation[] anns = field.getDeclaredAnnotations();

            if (anns.length < 1) {
                continue;
            }

            // 判断注解类型
            if (anns[0] instanceof SQLInteger) {
                SQLInteger sInt = (SQLInteger) anns[0];
                // 获取字段对应列名称，如果没有就用字段名称替代
                if (sInt.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sInt.name();
                }
                columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
            }

            // 判断String类型
            if (anns[0] instanceof SQLString) {
                SQLString sString = (SQLString) anns[0];
                if (sString.name().length() < 1) {
                    columnName = field.getName().toUpperCase();
                } else {
                    columnName = sString.name();
                }
                columnDefs.add(columnName + " VARCHAR(" +
                        sString.value() + ")" +
                        getConstraints(sString.constraints()));
            }
        }

        String tableCreate = null;
        StringBuilder createCommand = new StringBuilder(
                "CREATE TABLE " + tableName + "(");
        for (String columnDef : columnDefs) {
            createCommand.append("\n " + columnDef + ",");

            // remove trailing comma
            tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
        }

        return tableCreate;
    }

    private static String getConstraints(Constraints con) {
        StringBuffer sb = new StringBuffer();
        if (!con.allowNull()) {
            sb.append(" NOT NULL");
        }
        if (con.primaryKey()) {
            sb.append(" PRIMARY KEY");
        }
        if (con.unique()) {
            sb.append(" UNIQUE");
        }
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        String[] arg = {"com.javahouse.jdk.annotation.Member"};
        for (String className : arg) {
            System.out.println("Talbe Create SQL for " +
                    className + " is :\n" +
                    createTableSql(className));
        }


    }



}
