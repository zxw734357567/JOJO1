package com.example.demo.common;

/**
 * @Author zhangxw
 * @Description:
 * @Date Created in 2019/4/24  11:07.
 * @Modified by:
 */
public class RedisKeyUtil {
    /**
     * redis的key
     * 形式为：
     * 表名:主键名:主键值:列名
     *
     * @param tableName 表名
     * @param majorKey 主键名
     * @param majorKeyValue 主键值
     * @param column 列名
     * @return 列名值
     */
    public static String getKeyWithColumn(String tableName,String majorKey,String majorKeyValue,String column){
        StringBuffer buffer = new StringBuffer();
        buffer.append(tableName).append(":");
        buffer.append(majorKey).append(":");
        buffer.append(majorKeyValue).append(":");
        buffer.append(column);
        return buffer.toString();
    }
    /**
     * redis的key
     * 形式为：
     * 表名:主键名:主键值
     *
     * @param tableName 表名
     * @param majorKey 主键名/主键值
     * @param majorKeyValue 主键值/列名
     * @return 实体
     */
    public static String getKey(String tableName,String majorKey,String majorKeyValue){
        StringBuffer buffer = new StringBuffer();
        buffer.append(tableName).append(":");
        buffer.append(majorKey).append(":");
        buffer.append(majorKeyValue).append(":");
        return buffer.toString();
    }
}
