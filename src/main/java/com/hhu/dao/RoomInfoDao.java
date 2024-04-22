package com.hhu.dao;


import com.hhu.domain.entity.RoomInfo;


public interface RoomInfoDao extends BaseDao<RoomInfo>{
    void Delete(Long pk) throws Exception;
}
