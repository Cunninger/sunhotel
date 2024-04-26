package com.hhu;

/**
 * 功能：
 * 日期：2024/4/26 上午8:05
 */
import com.hhu.domain.entity.Livein;
import com.hhu.service.Impl.LiveinServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class uulTest {

    @Test
    public void testInsert() throws Exception {
        Livein livein = new Livein();
        livein.setPk(BigDecimal.valueOf(8L));
        livein.setInNo("IN123");
        livein.setrNo("R123");
        livein.setrTypeId("RT123");
        livein.setMainRoom("MR123");
        livein.setMainPk("345677654");
        livein.setcTypeId("CT123");
        livein.setcName("CN123");
        livein.setcJp("CJ123");
        livein.setSex("S123");
        livein.setZjType("ZJT123");
        livein.setZjNo("ZJN123");
        livein.setAddress("A123");
        livein.setRenshu(123);
        // 设置时间为当前时间
        livein.setInTime(String.valueOf(new Date()));
        livein.setAccount(123.0);
        livein.setDays(123);
        livein.setForegift(123.0);
        livein.setRemark("R123");
        livein.setmId("M123");
        livein.setChkNo("CN123");
        livein.setChkTime("CT123");
        livein.setUserId("UI123");
        livein.setStatemark("SM123");
        livein.setCluemark(123);
        livein.setDelmark(123);

        // 创建LiveinServiceImpl对象并调用insert方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        liveinService.insert(livein);


    }
    @Test
    public void testUpdate() throws Exception {
        // 创建一个新的Livein对象并设置其属性
        Livein livein = new Livein();
        livein.setPk(BigDecimal.valueOf(1L));
        livein.setInNo("饿的23");
        livein.setrNo("R123");
        livein.setrTypeId("RT123");
        livein.setMainRoom("MR123");
        livein.setMainPk("345677654");
        livein.setcTypeId("CT123");
        livein.setcName("CN123");
        livein.setcJp("CJ123");
        livein.setSex("S123");
        livein.setZjType("ZJT123");
        livein.setZjNo("ZJN123");
        livein.setAddress("A123");
        livein.setRenshu(123);
        // 设置时间为当前时间
        livein.setInTime(String.valueOf(new Date()));
        livein.setAccount(123.0);
        livein.setDays(123);
        livein.setForegift(123.0);
        livein.setRemark("R123");
        livein.setmId("M123");
        livein.setChkNo("CN123");
        livein.setChkTime("CT123");
        livein.setUserId("UI123");
        livein.setStatemark("SM123");
        livein.setCluemark(123);
        livein.setDelmark(123);

        // 创建LiveinServiceImpl对象并调用update方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        liveinService.update(livein);
    }

    @Test
    public void testDeleteByPk() throws Exception {
        // 创建LiveinServiceImpl对象并调用deleteByPk方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        liveinService.deleteByPk(1L);
    }

    @Test
    public void testDeleteByPks() throws Exception {
        // 创建LiveinServiceImpl对象并调用deleteByPks方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        liveinService.deleteByPks(new Long[]{1L, 2L, 3L});
    }

    @Test
    public void testSelectByPk() throws Exception {
        // 创建LiveinServiceImpl对象并调用selectByPk方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        Livein livein = liveinService.selectByPk(1L);
        System.out.println(livein);
    }

    @Test
    public void testSelectAll() throws Exception {
        // 创建LiveinServiceImpl对象并调用selectAll方法
        LiveinServiceImpl liveinService = new LiveinServiceImpl();
        List<Livein> liveins = liveinService.selectAll();
        for(var i:liveins){
            System.out.println(i);
        }

    }



}