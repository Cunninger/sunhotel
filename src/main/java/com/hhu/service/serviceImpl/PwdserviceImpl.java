package com.hhu.service.serviceImpl;

import com.hhu.dao.PwdDao;
import com.hhu.dao.impl.PwdDaoImpl;
import com.hhu.domain.entity.Pwd;
import com.hhu.service.Pwdservice;

import java.util.List;

public class PwdserviceImpl implements Pwdservice {
    private PwdDao pwdDao=new PwdDaoImpl();
    public void save(Pwd pwd)throws Exception{
        pwdDao.insert(pwd);
    }

    @Override
    public List<Pwd> findAll() throws Exception {
       return pwdDao.selectAll();
    }

    @Override
    public List<Pwd> findByUserId(Pwd pwd) throws Exception {
        return pwdDao.selectBySelective(pwd);
    }
}
