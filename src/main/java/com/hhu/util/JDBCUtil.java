//package com.hhu.util;
//
//import java.sql.*;
//
///**
// * JDBC操作类
// * @author ke
// * @version 1.0
// * @date 2024-3-15
// */
//public class JdbcUtils {
//    private static Connection conn ; // 连接对象
//    private static PreparedStatement ps; // 发送SQL对象
//    private static ResultSet rs; // 结果集
//    /*
//     * 初始化连接对象
//     * 1、加载驱动
//     * 2、创建连接
//     */
//    static {
//        try {
//            // 1、加载驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            // 2、创建连接
//            String url = "jdbc:mysql://localhost:3306/sunhotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
//            String username = "root";
//            String password = "1234";
//            conn = DriverManager.getConnection(url,username,password);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 数据更新
//     * @param sql
//     * @param params 更新数据的参数
//     * @return 影响的行数
//     * @throws Exception
//     */
//    public static int update(String sql,Object[] params) throws Exception {
//        // 创建sql语句
//        ps = conn.prepareStatement(sql);
//        // 添加参数
//        for (int i = 0; i < params.length;i++){
//            ps.setObject(i+1,params[i]);
//        }
//        // 发送sql，如果更新失败，影响行数<=0,否则返回 n>=1
//        return ps.executeUpdate();
//    }
//
//    /**
//     * 数据查询
//     * @param sql
//     * @return 查询的结果集
//     * @throws Exception
//     */
//    public static ResultSet query(String sql) throws Exception {
//        ps = conn.prepareStatement(sql);
//        return ps.executeQuery();
//    }
//    public static ResultSet query(String sql,Object[] params) throws Exception{
//        ps = conn.prepareStatement(sql);
//        for (int i = 0; i < params.length;i++){
//            ps.setObject(i+1,params[i]);
//        }
//        return ps.executeQuery();
//    }
//}
package com.hhu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JDBC操作工具类
 * @Author: liuweifeng
 * @Date: 2024/3/15 10:20
 * @version: v1.0
 */
public class JDBCUtil {
    private static Connection conn;//连接对象
    private static PreparedStatement ps;//预编译对象
    private static ResultSet rs;//结果集对象
    static {
        //静态代码块，类加载时执行
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动
            String url = "jdbc:mysql://localhost:3306/sunhotel?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
            String user = "root";
            String password = "1234";
            conn = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新操作
     * @param sql
     * @param params 参数
     * @return 影响行数，如果为0则表示更新失败
     * @throws Exception
     */
    public static int update(String sql, Object... params) {//更新操作
        try {
            ps =  conn.prepareStatement(sql);//预编译
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);//设置参数
            }
            return ps.executeUpdate();//执行更新
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出异常
        }
    }

    /**
     * 查询操作
     * @param sql
     * @param params
     * @return ResultSet
     * @throws Exception
     */
    public static ResultSet query(String sql, Object... params) {//查询操作
        try {
            ps = conn.prepareStatement(sql);//预编译
            for (int i = 0; i < params.length; i++) {//设置参数
                ps.setObject(i + 1, params[i]);//设置参数
            }
            return ps.executeQuery();//执行查询
        } catch (Exception e) {
            throw new RuntimeException(e);//抛出异常
        }
    }

}
