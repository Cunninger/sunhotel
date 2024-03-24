package com.hhu.service;

import com.hhu.domain.entity.Member;

import java.util.List;

public interface MemberService {
    void save(Member member)throws Exception;
    void update(Member member)throws Exception;
    List<Member> findByUserId(Member member)throws Exception;
    void delete(Member member)throws Exception;
    void updateByDelmark(Member member)throws Exception;
    List<Member> findByMName(Member member)throws Exception;
    List<Member> findByDelmark(Member member)throws Exception;
}
