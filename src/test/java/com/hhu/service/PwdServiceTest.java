package com.hhu.service;

import com.hhu.domain.entity.Pwd;
import com.hhu.service.Impl.PwdServiceImpl;
import org.junit.Test;

import java.util.List;

public class PwdServiceTest {
    private PwdService pwdservice=new PwdServiceImpl();
    @Test
    public void save()throws  Exception{
        Pwd pwd=new Pwd("my","123456","测试员");
        pwdservice.save(pwd);
    }
    @Test
    public void findAll()throws Exception{
        List<Pwd> list=pwdservice.findAll();
        for (Pwd pwd:list){
            System.out.println(pwd);
        }
    }
    @Test
    public void findByUserId()throws Exception{
        Pwd pwd1=new Pwd();
        pwd1.setUserId("my");
        List<Pwd>list=pwdservice.findByUserId(pwd1);
        for (Pwd pwd:list){
            System.out.println(pwd);
        }
    }
}
