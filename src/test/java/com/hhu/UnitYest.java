package com.hhu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UnitYest {
    @Test
    public void testAppHasAGreeting() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/adb1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
            //创建连接
            String user = "root";
            String password = "2248290361";
            Connection con = DriverManager.getConnection(url,user,password);
            //创建statement
            String sql = "insert into checkout values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"1");
            ps.setString(2,"2");
            ps.setString(3,"3");
            ps.setString(4,"4");
            ps.setString(5,"5");
            ps.setString(6,"6");
            ps.setString(7,"7");
            //执行sql
            int cnt=ps.executeUpdate();
            //处理结果
            if (cnt>0)
                 System.out.println("连接成功："+cnt);
            else
                throw new Exception("数据操作失败");
            //关闭连接
            if(ps!=null)ps.close();//关闭statement
            if(con!=null)con.close();//关闭连接

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testAppHasAGreeting2() {
       try{
           Class.forName("com.mysql.jdbc.Driver");
           //远程连接url
           //String url= "jdbc:mysql://localhost:3306/abd1?useSSL=false&useUnicode=true&&characterEncoding=UTF-8";
           String url= "jdbc:mysql://localhost:3306/adb1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";
           //创建连接
              String user = "root";
              String password = "2248290361";
              Connection con = DriverManager.getConnection(url,user,password);
              //创建statement
                String sql = "select * from checkout";
           PreparedStatement ps = con.prepareStatement(sql);
              //执行sql
                ResultSet rs=ps.executeQuery();
                //处理结果
                while (rs.next()){

                    System.out.print(rs.getString(1)+" ");
                    System.out.print(rs.getString(2)+" ");
                    System.out.print(rs.getString(3)+" ");
                    System.out.print(rs.getString(4)+" ");
                    System.out.print(rs.getString(5)+" ");
                    System.out.print(rs.getString(6)+" ");
                    System.out.println(rs.getString(7));
                }
                System.out.println("连接成功："+rs);
                //关闭连接
                if (rs!=null)rs.close();//关闭结果集
                if(ps!=null)ps.close();//关闭statement
                if(con!=null)con.close();//关闭连接

       }catch (Exception e){
          throw new RuntimeException(e);
       }
    }
}
