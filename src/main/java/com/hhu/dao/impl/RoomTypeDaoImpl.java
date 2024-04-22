package com.hhu.dao.impl;

import com.hhu.dao.RoomTypeDao;
import com.hhu.domain.entity.RoomType;
import com.hhu.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDaoImpl implements RoomTypeDao {
    @Override
    public void insert(RoomType roomType) throws Exception {

    }

    @Override
    public void update(RoomType roomType) throws Exception {

    }

    @Override
    public void delete(Long pk) throws Exception {

    }

    @Override
    public void Delete(Long pk) throws Exception {

    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {

    }

    @Override
    public List<RoomType> selectAll() throws Exception {
        String sql = "select * from roomtype";
            ResultSet rs =  JDBCUtil.query(sql);
        List<RoomType> list = new ArrayList<>();
        while (rs.next()){
            RoomType roomType = new RoomType();
            roomType.setBed(rs.getString("bed"));
            roomType.setrType(rs.getString("r_type"));
            roomType.setForegift(rs.getDouble("foregift"));
            roomType.setId(rs.getString("id"));
            roomType.setPk(rs.getLong("pk"));
            roomType.setClPrice(rs.getDouble("cl_price"));
            roomType.setPrice(rs.getDouble("price"));
            roomType.setClRomm(rs.getString("cl_room"));
            list.add(roomType);
        }
        return list;
    }

    @Override
    public List<RoomType> selectBySelective(RoomType roomType) throws Exception {
        return null;
    }

    @Override
    public RoomType selectById(Long pk) throws Exception {
        return null;
    }

    @Override
    public RoomType selectByUserId(String userId) throws Exception {
        return null;
    }
}
