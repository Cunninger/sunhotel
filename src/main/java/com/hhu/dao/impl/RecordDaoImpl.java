package com.hhu.dao.impl;
import com.hhu.dao.RecordDao;
import com.hhu.domain.entity.Record;
import com.hhu.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.List;

public class RecordDaoImpl implements RecordDao{
    @Override
    public void insert(Record record) throws Exception {
        String sql = "insert into record values(?,?,?,?,?,?)";
        Object[] params = {record.getPk(),record.getTime(),record.getOperator(),
                record.getBrief(),record.getContent(),record.getDelmark()};
        int rows = JDBCUtil.update(sql, params);
        if(rows <= 0){
            throw new Exception("数据添加失败");
        }
    }

    @Override
    public void update(Record recod) throws Exception {
        String sql = "update recod set time=?,operator=?,brief=?,content=?,delmark=? where pk=?";
        JDBCUtil.update(sql, recod.getTime(), recod.getOperator(), recod.getBrief(), recod.getContent(), recod.getDelmark(), recod.getPk());

    }

    @Override
    public void delete(Long pk) throws Exception {
        String sql = "update  recod set delmark=1 where pk=?";
        JDBCUtil.update(sql, pk);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {
        String sql = "update  recod set delmark=1 where pk=?";
        for (Long pk : pks) {
            JDBCUtil.update(sql, pk);
        }
    }

    @Override
    public List<Record> selectAll() throws Exception {
        String sql = "select * from ";
        ResultSet rs=JDBCUtil.query(sql);
        List<Record> list = null;
        while (rs.next()){
            Record recod=new Record();
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
    public List<Record> selectBySelective(Record recod) throws Exception {
        String sql = "select * from recod where pk=? and time=? and operator=? and brief=? and content=?";
        ResultSet rs = JDBCUtil.query(sql, recod.getPk(), recod.getTime(), recod.getOperator(), recod.getBrief(), recod.getContent());
        List<Record> list = null;
        while (rs.next()){
            Record recod1=new Record();
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
    public Record selectById(Long pk) throws Exception {
        String sql = "select * from record where pk=?";
        ResultSet rs = JDBCUtil.query(sql, pk);
        Record record = new Record();
        while (rs.next()){
            record.setPk(rs.getLong(1));
            record.setTime(rs.getString(2));
            record.setOperator(rs.getString(3));
            record.setBrief(rs.getString(4));
            record.setContent(rs.getString(5));
            record.setDelmark(rs.getInt(6));
        }
        return record;
    }

    @Override
    public Record selectByUserId(String userId) throws Exception {
        String sql = "select * from record where operator=?";
        ResultSet rs = JDBCUtil.query(sql, userId);
        Record record = new Record();
        while (rs.next()){
            record.setPk(rs.getLong(1));
            record.setTime(rs.getString(2));
            record.setOperator(rs.getString(3));
            record.setBrief(rs.getString(4));
            record.setContent(rs.getString(5));
            record.setDelmark(rs.getInt(6));
        }
        return record;
    }
}
