
package com.hhu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JDBCUtil {
    private static Connection conn;//连接对象
    private static PreparedStatement ps;//预编译对象
    private static ResultSet rs;//结果集对象
    static {
        //静态代码块，类加载时执行
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
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
