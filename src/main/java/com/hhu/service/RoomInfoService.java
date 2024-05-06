package com.hhu.service;

import com.hhu.domain.entity.RoomInfo;

import java.util.List;

public interface RoomInfoService {
    List<RoomInfo> getAll() throws Exception;
   // roomInfoService.updateByState(roomInfoId,"占用");
//    void update(RoomInfo roomInfo, String state) throws Exception;

    void updateByState(String roomInfoId, String state);

    List<RoomInfo> selectAll() throws Exception;
}
