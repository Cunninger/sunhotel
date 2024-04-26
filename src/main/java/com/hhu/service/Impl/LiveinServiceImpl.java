package com.hhu.service.Impl;

/**
 * 功能：
 * 日期：2024/4/26 上午7:58
 */

import com.hhu.dao.LiveinDao;
import com.hhu.dao.impl.LiveinDaoImpl;
import com.hhu.domain.entity.Livein;
import com.hhu.service.LiveinService;

import java.util.List;

public class LiveinServiceImpl implements LiveinService {
    private LiveinDao liveinDao=new LiveinDaoImpl();
    public void insert(Livein livein) throws Exception {
        liveinDao.insert(livein);
    }

    @Override
    public void update(Livein livein) throws Exception {
        liveinDao.update(livein);
    }

    @Override
    public void deleteByPk(Long pk) throws Exception {
        liveinDao.delete(pk);
    }

    @Override
    public void deleteByPks(Long[] pks) throws Exception {
        liveinDao.batchDelete(pks);
    }

    @Override
    public Livein selectByPk(Long pk) throws Exception {
        return liveinDao.selectById(pk);
    }

    @Override
    public List<Livein> selectAll() throws Exception {
        return liveinDao.selectAll();
    }
}
