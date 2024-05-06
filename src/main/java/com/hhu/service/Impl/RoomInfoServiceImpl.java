package com.hhu.service.Impl;

import com.hhu.dao.RoomInfoDao;
import com.hhu.dao.impl.RoomInfoDaoImpl;
import com.hhu.domain.entity.RoomInfo;
import com.hhu.service.RoomInfoService;

import java.util.List;

public class RoomInfoServiceImpl implements RoomInfoService {
    private RoomInfoDao roomInfoDao = new RoomInfoDaoImpl();
    @Override
    public List<RoomInfo> getAll() throws Exception {
        return roomInfoDao.selectAll();
    }

    @Override
    public void updateByState(String roomInfoId, String state) {
        roomInfoDao.updateByState(roomInfoId, state);
    }

    @Override
    public List<RoomInfo> selectAll() throws Exception {

        return   roomInfoDao.selectAll();
    }


}
