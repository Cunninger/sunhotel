package com.hhu.dao.impl;

import com.hhu.dao.RoomInfoDao;
import com.hhu.domain.entity.RoomInfo;
import com.hhu.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomInfoDaoImpl implements RoomInfoDao {
    @Override
    public void insert(RoomInfo roomInfo) throws Exception {

    }

    @Override
    public void update(RoomInfo roomInfo) throws Exception {

    }

    @Override
    public void delete(Long pk) throws Exception {

    }

    @Override
    public void Delete(Long pk) throws Exception {

    }

    @Override
    public void updateByState(String roomInfoId, String state) {
        String sql = "update roominfo set state = ? where id = ?";
        JDBCUtil.update(sql,state,roomInfoId);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {

    }

    @Override
    public List<RoomInfo> selectAll() throws Exception {
        String sql = "select pk,id,r_type_id,state,location,r_tel from roominfo";
        ResultSet rs = JDBCUtil.query(sql);
        List<RoomInfo> list = new ArrayList<>();
        while (rs.next()){
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setId(rs.getString("id"));
            roomInfo.setPk(rs.getLong("pk"));
            roomInfo.setLocation(rs.getString("location"));
            roomInfo.setrTypeId(rs.getString("r_type_id"));
            roomInfo.setState(rs.getString("state"));
            roomInfo.setrTel(rs.getString("r_tel"));
            list.add(roomInfo);
        }
        return list;
    }

    @Override
    public List<RoomInfo> selectBySelective(RoomInfo roomInfo) throws Exception {
        return null;
    }

    @Override
    public RoomInfo selectById(Long pk) throws Exception {
        return null;
    }

    @Override
    public RoomInfo selectByUserId(String userId) throws Exception {
        return null;
    }
}
