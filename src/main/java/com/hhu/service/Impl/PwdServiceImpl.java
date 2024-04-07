package com.hhu.service.Impl;

import com.hhu.dao.PwdDao;
import com.hhu.dao.impl.PwdDaoImpl;
import com.hhu.domain.entity.Pwd;
import com.hhu.service.PwdService;

import java.util.List;

public class PwdServiceImpl implements PwdService {
    private PwdDao pwdDao = new PwdDaoImpl();

    public void save(Pwd pwd) throws Exception {
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

    @Override
    public Boolean login(String userId, String password) throws Exception {
        Pwd pwd = new Pwd();
        pwd.setUserId(userId);
        pwd.setPwd(password);
        List<Pwd> pwds = pwdDao.selectBySelective(pwd);
        if (pwds.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
