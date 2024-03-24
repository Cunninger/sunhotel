package com.hhu.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtilTest {
    @Test
    public void test1()throws Exception {
        String sql = "select * from member";
        ResultSet rs = JDBCUtil.query(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
        }
    }
    @Test
    public void test2()throws Exception {
        String sql = "select * from member where m_name like ?";
        ResultSet rs = JDBCUtil.query(sql,"张%");
        while (rs.next()) {
            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7));
        }
    }
    @Test
    public void test3()throws Exception {
        String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
        int cnt = JDBCUtil.updata(sql, "6020221840","123","雷紫嫣","女","123","4648656","家里蹲",null,1,null,null);
        if (cnt > 0)
            System.out.println("连接成功：" + cnt);
        else
            throw new Exception("数据操作失败");
    }
}
