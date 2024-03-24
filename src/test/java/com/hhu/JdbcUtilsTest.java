//package com.hhu;
//
//import java.sql.ResultSet;
//
//import com.hhu.util.JdbcUtils;
//import org.junit.Test;
//public class JdbcUtilsTest {
//    @Test
//    public void test1() throws Exception {
//        String sql = "select userid,puis from pwd";
//        ResultSet rs = JdbcUtils.query(sql);
//        while (rs.next()){
//            System.out.println(rs.getString(1) +
//                    "\t" + rs.getString(2));
//
//        }
//
//    }
//    @Test
//    public void test2() throws Exception {
//        String sql = "select userid,puis from pwd where userid=?";
//        Object[] params = {"admin"};
//        ResultSet rs = JdbcUtils.query(sql,params);
//        while (rs.next()){
//            System.out.println(rs.getString(1) +
//                    "\t" + rs.getString(2));
//        }
//    }
//    @Test
//    public void test3() throws Exception {
//        String sql = "insert into pwd VALUES(?,?,?,?,?,?,?)";
//        Object[] params = {100,"test100","123456","test100",0,null,null};
//        int rows = JdbcUtils.update(sql,params);
//        if(rows > 0 ){
//            System.out.println("数据添加成功");
//        }else{
//            System.out.println("数据添加失败");
//        }
//    }
//
//
//    @Test
//    public void test4() throws Exception {
//        String sql = "select * from member";
//        ResultSet rs = JdbcUtils.query(sql);
//        while (rs.next()){
//            System.out.println(rs.getString(1) +
//                    "\t" + rs.getString(2) +
//                    "\t" + rs.getString(3) +
//                    "\t" + rs.getString(4) +
//                    "\t" + rs.getString(5) +
//                    "\t" + rs.getString(6) +
//                    "\t" + rs.getString(7) +
//                    "\t" + rs.getString(8));
//        }
//        }
//
//
//    @Test
//    public void test5() throws Exception {
//        String sql = "select * from member where m_name like ?";
//        Object[] params = {"张%"};
//        ResultSet rs = JdbcUtils.query(sql,params);
//        while (rs.next()){
//
//            System.out.println(rs.getString(1) +
//                    "\t" + rs.getString(2) +
//                    "\t" + rs.getString(3) +
//                    "\t" + rs.getString(4) +
//                    "\t" + rs.getString(5) +
//                    "\t" + rs.getString(6) +
//                    "\t" + rs.getString(7) +
//                    "\t" + rs.getString(8));
//        }
//        }
//
//    @Test
//    public void test6() throws Exception {
//        String sql = "insert into member VALUES(?, ?,?,?, ?,?,?,?,?,?,?)";
//        Object[] params = {"6020221846", "123","刘熠昕","女","34543","23","jiangxi",null,0,null,null};
//        int rows = JdbcUtils.update(sql,params);
//        if(rows > 0 ){
//            System.out.println("数据添加成功");
//        }else{
//            System.out.println("数据添加失败");
//        }
//    }
//    }
//
//
//
