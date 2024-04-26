package com.hhu.dao;

import com.hhu.domain.entity.Livein;

import java.util.List;

public interface LiveinDao {


    void update(Livein livein) throws Exception;

    void delete(Long pk) throws Exception;

    void batchDelete(Long[] pks) throws Exception;

    List<Livein> selectAll() throws Exception;

    List<Livein> selectBySelective(Livein livein) throws Exception;

    Livein selectById(Long pk) throws Exception;

    Livein selectByUserId(String userId) throws Exception;

    void insert(Livein livein) throws Exception;


}
