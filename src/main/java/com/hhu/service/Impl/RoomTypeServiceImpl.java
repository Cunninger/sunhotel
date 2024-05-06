package com.hhu.service.Impl;

import com.hhu.dao.RoomTypeDao;
import com.hhu.dao.impl.RoomTypeDaoImpl;
import com.hhu.domain.entity.RoomType;
import com.hhu.service.RoomTypeService;

import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {
    private RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();
    @Override
    public List<RoomType> getAll() throws Exception {
        return roomTypeDao.selectAll();
    }

    @Override
    public List<RoomType> selectAll() throws Exception {
        return roomTypeDao.selectAll();
    }
}
