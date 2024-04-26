package com.hhu.service;


import com.hhu.domain.entity.Livein;

import java.util.List;

public interface LiveinService {
    void insert(Livein livein) throws Exception;
    void update(Livein livein)throws Exception;
    void deleteByPk(Long pk)throws Exception;
    void deleteByPks(Long[]pks)throws Exception;
    Livein selectByPk(Long pk)throws Exception;
    List<Livein> selectAll()throws Exception;
}
