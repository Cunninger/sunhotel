package com.hhu.service.Impl;

import com.hhu.dao.PwdDao;
import com.hhu.dao.impl.PwdDaoImpl;
import com.hhu.domain.entity.Pwd;
import com.hhu.service.PwdService;

import java.util.List;

public class PwdServiceImpl implements PwdService {
    private PwdDao pwdDao = new PwdDaoImpl();

    public void save(Pwd pwd) throws Exception {
        // 如果用户名已经被注册，则抛出异常

        Pwd pwds = pwdDao.selectByUserId(pwd.getUserId());
        if (pwds.getUserId() != null) {
            throw new Exception("用户名已经被注册");
        }
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

        if (pwds.size() == 0) {
            // 抛出异常
            throw new Exception("用户名或密码错误");

        } else {
            return true;
        }
    }
}
