package com.hhu.dao.impl;
import com.hhu.dao.PwdDao;
import com.hhu.domain.entity.Pwd;
import com.hhu.util.JDBCUtil;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
public class PwdDaoImpl implements PwdDao{

    @Override
    public void insert(Pwd pwd) throws Exception {
        String sql = "insert into pwd values(?,?,?,?,?)";
        JDBCUtil.updata(sql, pwd.getPk(), pwd.getUserId(), pwd.getPwd(), pwd.getPuis(), pwd.getDelmark());

    }

    @Override
    public void update(Pwd pwd) throws Exception {
        String sql = "update pwd set userId=?,pwd=?,puis=?,delmark=? where pk=?";
        JDBCUtil.updata(sql, pwd.getUserId(), pwd.getPwd(), pwd.getPuis(), pwd.getDelmark(), pwd.getPk());
    }

    @Override
    public void delete(Long pk) throws Exception {
        String sql = "update  pwd set delmark=1 where pk=?";
        JDBCUtil.updata(sql, pk);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {
        String sql = "update pwd set delmark=1 where pk=?";
        for (Long pk : pks) {
            JDBCUtil.updata(sql, pk);
        }
    }

    @Override
    public List<Pwd> selectAll() throws Exception {
        String sql = "select * from pwd";
        ResultSet rs = JDBCUtil.query(sql);
        List<Pwd> list = new ArrayList<>();
        while (rs.next()) {
            Pwd pwd1 = new Pwd();
            pwd1.setPk(rs.getLong(1));
            pwd1.setUserId(rs.getString(2));
            pwd1.setPwd(rs.getString(3));
            pwd1.setPuis(rs.getString(4));
            pwd1.setDelmark(rs.getInt(5));
            list.add(pwd1);
        }
        return list;
    }

    @Override
    public List<Pwd> selectBySelective(Pwd pwd) throws Exception {
            String sql="select * from pwd where  userId=? ";
            ResultSet rs = JDBCUtil.query(sql,  pwd.getUserId());
            List<Pwd> list = new ArrayList<>();
            while (rs.next()) {
                Pwd pwd1 = new Pwd();
                pwd1.setPk(rs.getLong(1));
                pwd1.setUserId(rs.getString(2));
                pwd1.setPwd(rs.getString(3));
                pwd1.setPuis(rs.getString(4));
                pwd1.setDelmark(rs.getInt(5));
                list.add(pwd1);
            }
            return list;
    }

    @Override
    public Pwd selectById(Long pk) throws Exception {
        String sql = "select * from pwd where pk=?";
        ResultSet rs = JDBCUtil.query(sql, pk);
        Pwd pwd1 = new Pwd();
        while (rs.next()) {
            pwd1.setPk(rs.getLong(1));
            pwd1.setUserId(rs.getString(2));
            pwd1.setPwd(rs.getString(3));
            pwd1.setPuis(rs.getString(4));
            pwd1.setDelmark(rs.getInt(5));
        }
        return pwd1;
    }
}
