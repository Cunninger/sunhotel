package com.hhu.dao.impl;

import com.hhu.dao.MemberDao;
import com.hhu.domain.entity.Member;
import com.hhu.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    @Override
    public void insert(Member member) throws Exception {
        String sql="insert into member values(?,?,?,?,?,?,?,?,?)";
        JDBCUtil.update(sql,member.getPk(),member.getmId(),member.getmName(),member.getSex(),member.getZjNo(),member.getmTel(),member.getAddress(),member.getRemark(),member.getDelmark());
    }

    @Override
    public void update(Member member) throws Exception {
        String sql="update member set m_id=?,m_name=?,sex=?,zj_no=?,m_tel=?,address=?,remark=?,delmark=? where pk=?";
        JDBCUtil.update(sql,member.getmId(),member.getmName(),member.getSex(),member.getZjNo(),member.getmTel(),member.getAddress(),member.getRemark(),member.getDelmark(),member.getPk());
    }

    @Override
    public void delete(Long pk) throws Exception {
        String sql="update member set delmark=1 where pk=?";
        JDBCUtil.update(sql,pk);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {
        String sql="update member set delmark=1 where pk=?";
        for(Long pk:pks)
        JDBCUtil.update(sql,pk);
    }

    @Override
    public List<Member> selectAll() throws Exception {
        String sql="select * from member";
        ResultSet rs=JDBCUtil.query(sql);
        List<Member> list=new ArrayList<>();
        while (rs.next()){
            Member m=new Member();
            m.setPk(rs.getString(1));
            m.setmId(rs.getString(2));
            m.setmName(rs.getString(3));
            m.setSex(rs.getString(4));
            m.setZjNo(rs.getString(5));
            m.setmTel(rs.getString(6));
            m.setAddress(rs.getString(7));
            m.setRemark(rs.getString(8));
            m.setDelmark(rs.getInt(9));
            list.add(m);
        }
        return list;
    }

    @Override
    public List<Member> selectBySelective(Member member) throws Exception {
        String sql;
        ResultSet rs;
        if(member.getDelmark()==1){
            sql="select * from member where  delmark=0";
             rs=JDBCUtil.query(sql);
        }else {
            sql="select * from member where m_name=?" ;
            rs=JDBCUtil.query(sql,member.getmName());
        }

        List<Member> list=new ArrayList<>();
        while (rs.next()){
            Member m=new Member();
            m.setPk(rs.getString(1));
            m.setmId(rs.getString(2));
            m.setmName(rs.getString(3));
            m.setSex(rs.getString(4));
            m.setZjNo(rs.getString(5));
            m.setmTel(rs.getString(6));
            m.setAddress(rs.getString(7));
            m.setRemark(rs.getString(8));
            m.setDelmark(rs.getInt(9));
            list.add(m);
        }
        return list;
    }

    @Override
    public Member selectById(Long pk) throws Exception {
        String sql="select * from member where pk=?";
        ResultSet rs=JDBCUtil.query(sql,pk);


            Member m=new Member();
            m.setPk(rs.getString(1));
            m.setmId(rs.getString(2));
            m.setmName(rs.getString(3));
            m.setSex(rs.getString(4));
            m.setZjNo(rs.getString(5));
            m.setmTel(rs.getString(6));
            m.setAddress(rs.getString(7));
            m.setRemark(rs.getString(8));
            m.setDelmark(rs.getInt(9));

        return m;
    }

    @Override
    public Member selectByUserId(String userId) throws Exception {
        String sql="select * from member where m_id=?";
        ResultSet rs=JDBCUtil.query(sql,userId);
        Member m=new Member();
        while (rs.next()){
            m.setPk(rs.getString(1));
            m.setmId(rs.getString(2));
            m.setmName(rs.getString(3));
            m.setSex(rs.getString(4));
            m.setZjNo(rs.getString(5));
            m.setmTel(rs.getString(6));
            m.setAddress(rs.getString(7));
            m.setRemark(rs.getString(8));
            m.setDelmark(rs.getInt(9));
        }
        return m;
    }
}
