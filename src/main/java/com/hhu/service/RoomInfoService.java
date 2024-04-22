package com.hhu.service;

import com.hhu.domain.entity.RoomInfo;

import java.util.List;

public interface RoomInfoService {
    List<RoomInfo> getAll() throws Exception;
}
