package com.hhu.service;

import com.hhu.domain.entity.Pwd;

import java.util.List;

/**
 * 业务层
 */
public interface Pwdservice {

    void save(Pwd pwd)throws Exception;
    List<Pwd> findAll()throws Exception;
    List<Pwd> findByUserId(Pwd pwd)throws Exception;
}
