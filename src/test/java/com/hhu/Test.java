package com.hhu;

import java.sql.*;

import static java.lang.Class.forName;

/**
 * 功能：
 * 日期：2024/3/11 16:22
 */

public class Test {
    @org.junit.Test
    public void test1() throws SQLException, ClassNotFoundException {
          /*
             1、加载驱动
             5.0 com.mysql.jdbc.Driver
             8.0 com.mysql.cj.jdbc.Driver
             */
       Class.forName("com.mysql.cj.jdbc.Driver");
            /*
              2 、创建连接
              5.0 jdbc:mysql://localhost:3306/hotel?useSSL=false&useUnicode=true&characterEncoding=utf-8
              8.0 jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
             */
        // 2.1 数据库远程连接URL
        //String url = "jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String url ="jdbc:mysql://localhost:3306/sunhotel?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        // 2.2 用户名和密码
        String username = "root";
        String password = "1234";
        // 2.3 创建连接
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3、创建statement
        String sql = "select * from checkout";
        PreparedStatement ps = conn.prepareStatement(sql);
        //4、执行（发送sql）
        ResultSet rs = ps.executeQuery();
        // 5、处理结果
        while (rs.next()) {
            // 列的序号
            // System.out.println(rs.getString(1) + "\t" + rs.getString(7));
            // 列名
            System.out.println(rs.getString("pk") + "\t" + rs.getString("remark"));
        }
        // 6、释放资源
        if (rs != null) rs.close();// 关闭结果集 resultset
        if (ps != null) ps.close(); // 关闭statement
        if (conn != null) conn.close();// 关闭连接  connection
    }
}