package com.hhu.service.Impl;

import com.hhu.dao.RecordDao;
import com.hhu.dao.impl.RecodDaoImpl;
import com.hhu.domain.entity.Record;
import com.hhu.service.RecordService;

/**
 * 功能：
 * 日期：2024/4/7 上午11:20
 */
public class RecordServiceImpl implements RecordService {
    private RecordDao recodDao=new RecodDaoImpl();

    @Override
    public void save(Record record) throws Exception {
        recodDao.insert(record);
    }
}