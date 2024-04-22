package com.hhu.dao;

import com.hhu.domain.entity.RoomType;

public interface RoomTypeDao extends BaseDao<RoomType>{
    void Delete(Long pk) throws Exception;
}
