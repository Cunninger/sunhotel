package com.hhu.service.serviceImpl;

import com.hhu.dao.MemberDao;
import com.hhu.dao.impl.MemberDaoImpl;
import com.hhu.domain.entity.Member;
import com.hhu.service.MemberService;
import com.hhu.util.JDBCUtil;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao=new MemberDaoImpl();
    @Override
    public void save(Member member) throws Exception {
        memberDao.insert(member);
    }

    @Override
    public void update(Member member) throws Exception {
        memberDao.update(member);
    }

    @Override
    public List<Member> findByUserId(Member member) throws Exception {
        return memberDao.selectBySelective(member);
    }

    @Override
    public void delete(Member member) throws Exception {
        memberDao.delete(member.getPk());
    }

    @Override
    public void updateByDelmark(Member member) throws Exception {
        member.setDelmark(1);
        memberDao.delete(member.getPk());
    }

    @Override
    public List<Member> findByMName(Member member) throws Exception {
        return memberDao.selectBySelective(member);
    }

    @Override
    public List<Member> findByDelmark(Member member) throws Exception {
        return memberDao.selectBySelective(member);
    }
}
