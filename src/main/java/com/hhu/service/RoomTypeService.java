package com.hhu.service;

import com.hhu.domain.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    List<RoomType> getAll() throws Exception;

    List<RoomType> selectAll() throws Exception;
}
