package com.hhu.dao.impl;
import com.hhu.dao.RecodDao;
import com.hhu.domain.entity.Recod;
import com.hhu.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.List;

public class RecodDaoImpl implements RecodDao{
    @Override
    public void insert(Recod recod) throws Exception {
        String sql = "insert into recod values(?,?,?,?,?,?,?)";
        JDBCUtil.updata(sql, recod.getPk(), recod.getTime(), recod.getOperator(), recod.getBrief(), recod.getContent(),null);
    }

    @Override
    public void update(Recod recod) throws Exception {
        String sql = "update recod set time=?,operator=?,brief=?,content=?,delmark=? where pk=?";
        JDBCUtil.updata(sql, recod.getTime(), recod.getOperator(), recod.getBrief(), recod.getContent(), recod.getDelmark(), recod.getPk());

    }

    @Override
    public void delete(Long pk) throws Exception {
        String sql = "update  recod set delmark=1 where pk=?";
        JDBCUtil.updata(sql, pk);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {
        String sql = "update  recod set delmark=1 where pk=?";
        for (Long pk : pks) {
            JDBCUtil.updata(sql, pk);
        }
    }

    @Override
    public List<Recod> selectAll() throws Exception {
        String sql = "select * from ";
        ResultSet rs=JDBCUtil.query(sql);
        List<Recod> list = null;
        while (rs.next()){
            Recod recod=new Recod();
            recod.setPk(rs.getLong(1));
            recod.setTime(rs.getString(2));
            recod.setOperator(rs.getString(3));
            recod.setBrief(rs.getString(4));
            recod.setContent(rs.getString(5));
            recod.setDelmark(rs.getInt(6));
            list.add(recod);
        }
        return list;
    }

    @Override
    public List<Recod> selectBySelective(Recod recod) throws Exception {
        String sql = "select * from recod where pk=? and time=? and operator=? and brief=? and content=?";
        ResultSet rs = JDBCUtil.query(sql, recod.getPk(), recod.getTime(), recod.getOperator(), recod.getBrief(), recod.getContent());
        List<Recod> list = null;
        while (rs.next()){
            Recod recod1=new Recod();
            recod1.setPk(rs.getLong(1));
            recod1.setTime(rs.getString(2));
            recod1.setOperator(rs.getString(3));
            recod1.setBrief(rs.getString(4));
            recod1.setContent(rs.getString(5));
            recod1.setDelmark(rs.getInt(6));
            list.add(recod1);
        }
        return list;
    }

    @Override
    public Recod selectById(Long pk) throws Exception {
        String sql = "select * from recod where pk=?";
        ResultSet rs = JDBCUtil.query(sql, pk);
        Recod recod = new Recod();
        while (rs.next()){
            recod.setPk(rs.getLong(1));
            recod.setTime(rs.getString(2));
            recod.setOperator(rs.getString(3));
            recod.setBrief(rs.getString(4));
            recod.setContent(rs.getString(5));
            recod.setDelmark(rs.getInt(6));
        }
        return recod;
    }
}
