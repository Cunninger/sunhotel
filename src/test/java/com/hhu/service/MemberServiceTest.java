//package com.hhu.service;
package com.hhu.service;
import com.hhu.domain.entity.Member;
import com.hhu.service.serviceImpl.*;
import org.junit.Test;

import java.util.List;

public class MemberServiceTest {
    private com.hhu.service.MemberService memberService=new com.hhu.service.serviceImpl.MemberServiceImpl();

    /**
     * 添加
     * @throws Exception
     */
    @Test
    public void insert() throws Exception {
        Member member=new Member("6020221841","2342","李静芸","女","5","5","5",null);
        memberService.save(member);
    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void update()throws Exception{
        Member member=new Member("6020221841","4321","李静芸","女","5","5","6",null);
        memberService.update(member);
    }

    /**
     * 删除
     * @throws Exception
     */
    @Test
    public void delete()throws Exception{
        Member member=new Member();
        member.setPk("6020221846");
        memberService.updateByDelmark(member);
    }

    /**
     * 按名字查询
     * @throws Exception
     */
    @Test
    public void selectByName() throws Exception {
        Member member=new Member();
        member.setmName("李静芸");
       List<Member> list= memberService.findByMName(member);
       for (Member member1:list){
           System.out.println(member1);
       }
    }

    /**
     * 查询未删除的
     * @throws Exception
     */
    @Test
    public void selectByDelmark()throws Exception{
        Member member=new Member();
        member.setDelmark(1);
        List<Member> list= memberService.findByMName(member);
        for (Member member1:list){
            System.out.println(member1);
        }
    }
}
