package com.hhu.dao.impl;

/**
 * 功能：
 * 日期：2024/4/26 上午7:54
 */

import com.hhu.dao.LiveinDao;
import com.hhu.domain.entity.Livein;
import com.hhu.util.JDBCUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LiveinDaoImpl implements LiveinDao {
    @Override
    public void insert(Livein livein) throws Exception {
        String sql = "insert into livein values(?,?,?,?" +
                ",?,?,?,?" +
                ",?,?,?,?" +
                ",?,?,?,?" +
                ",?,?,?,?" +
                ",?,?,?,?" +
                ",?,?)";
        JDBCUtil.update(sql, livein.getPk(), livein.getInNo(), livein.getrNo(), livein.getrTypeId(),
                livein.getMainRoom(), livein.getMainPk(), livein.getcTypeId(), livein.getcName(), livein.getcJp(),
                livein.getSex(), livein.getZjType(), livein.getZjNo(), livein.getAddress(),
                livein.getRenshu(), livein.getInTime(), livein.getAccount(), livein.getDays(),
                livein.getForegift(), livein.getRemark(), livein.getmId(), livein.getChkNo(), livein.getChkTime(),
                livein.getUserId(), livein.getStatemark(), livein.getCluemark(), livein.getDelmark());
    }

    @Override
    public void update(Livein livein) throws Exception {
        String sql = "update livein set in_no=?, r_no=?, r_type_id=?, " +
                "main_room=?, main_pk=?, c_type_id=?, c_name=?, c_jp=?," +
                " sex=?, zj_type=?, zj_no=?, address=?, " +
                "renshu=?, in_time=?, account=?, days=?," +
                " foregift=?, remark=?, m_id=?, chk_no=?, chk_time=?, " +
                "user_id=?, state_mark=?, clu_mark=?, del_mark=? " +
                "where pk=?";
        JDBCUtil.update(sql, livein.getInNo(), livein.getrNo(), livein.getrTypeId(),
                livein.getMainRoom(), livein.getMainPk(), livein.getcTypeId(), livein.getcName(), livein.getcJp(),
                livein.getSex(), livein.getZjType(), livein.getZjNo(), livein.getAddress(),
                livein.getRenshu(), livein.getInTime(), livein.getAccount(), livein.getDays().byteValue(),
                livein.getForegift(), livein.getRemark(), livein.getmId(), livein.getChkNo(), livein.getChkTime(),
                livein.getUserId(), livein.getStatemark(), livein.getCluemark(), livein.getDelmark(), livein.getPk());

    }


    @Override
    public void delete(Long pk) throws Exception {
        String sql = "update  livein set delmark = 0 where pk=?";
        JDBCUtil.update(sql, pk);
    }

    @Override
    public void batchDelete(Long[] pks) throws Exception {
        String sql = "update  livein set delmark = 0 where pk=?";
        for (Long pk : pks)
            JDBCUtil.update(sql, pk);
    }

    @Override
    public List<Livein> selectAll() throws Exception {
        String sql = "select * from livein";
        ResultSet resultSet = JDBCUtil.query(sql);
        List<Livein> list = new ArrayList<>();
        while (resultSet.next()) {
            Livein livein = new Livein();
            livein.setPk(BigDecimal.valueOf(resultSet.getLong("pk")));
            livein.setInNo(resultSet.getString("in_no"));
            livein.setrNo(resultSet.getString("r_no"));
            livein.setrTypeId(resultSet.getString("r_type_id"));
            livein.setMainRoom(resultSet.getString("main_room"));
            livein.setMainPk(resultSet.getString("main_pk"));
            livein.setcTypeId(resultSet.getString("c_type_id"));
            livein.setcName(resultSet.getString("c_name"));
            livein.setcJp(resultSet.getString("c_jp"));
            livein.setSex(resultSet.getString("sex"));
            livein.setZjType(resultSet.getString("zj_type"));
            livein.setZjNo(resultSet.getString("zj_no"));
            livein.setAddress(resultSet.getString("address"));
            livein.setRenshu(resultSet.getInt("renshu"));
            livein.setInTime(resultSet.getDate("in_time"));
            livein.setAccount(resultSet.getDouble("account"));
            livein.setDays(resultSet.getInt("days"));
            livein.setForegift(resultSet.getDouble("foregift"));
            livein.setRemark(resultSet.getString("remark"));
            livein.setmId(resultSet.getString("m_id"));
            livein.setChkNo(resultSet.getString("chk_no"));
            livein.setChkTime(resultSet.getString("chk_time"));
            livein.setUserId(resultSet.getString("user_id"));
            livein.setStatemark(resultSet.getString("state_mark"));
            livein.setCluemark(resultSet.getInt("clu_mark"));
            livein.setDelmark(resultSet.getInt("del_mark"));
            list.add(livein);
        }
        return list;
    }

    @Override
    public List<Livein> selectBySelective(Livein livein) throws Exception {
        return List.of();
    }


    @Override
    public Livein selectById(Long pk) throws Exception {
        String sql = "select * from livein where pk=?";
        ResultSet resultSet = JDBCUtil.query(sql, pk);
        Livein livein = new Livein();
        while (resultSet.next()) {
            livein.setPk(BigDecimal.valueOf(resultSet.getLong("pk")));
            livein.setInNo(resultSet.getString("in_no"));
            livein.setrNo(resultSet.getString("r_no"));
            livein.setrTypeId(resultSet.getString("r_type_id"));
            livein.setMainRoom(resultSet.getString("main_room"));
            livein.setMainPk(resultSet.getString("main_pk"));
            livein.setcTypeId(resultSet.getString("c_type_id"));
            livein.setcName(resultSet.getString("c_name"));
            livein.setcJp(resultSet.getString("c_jp"));
            livein.setSex(resultSet.getString("sex"));
            livein.setZjType(resultSet.getString("zj_type"));
            livein.setZjNo(resultSet.getString("zj_no"));
            livein.setAddress(resultSet.getString("address"));
            livein.setRenshu(resultSet.getInt("renshu"));
            livein.setInTime(resultSet.getDate("in_time"));
            livein.setAccount(resultSet.getDouble("account"));
            livein.setDays(resultSet.getInt("days"));
            livein.setForegift(resultSet.getDouble("foregift"));
            livein.setRemark(resultSet.getString("remark"));
            livein.setmId(resultSet.getString("m_id"));
            livein.setChkNo(resultSet.getString("chk_no"));
            livein.setChkTime(resultSet.getString("chk_time"));
            livein.setUserId(resultSet.getString("user_id"));
            livein.setStatemark(resultSet.getString("state_mark"));
            livein.setCluemark(resultSet.getInt("clu_mark"));
            livein.setDelmark(resultSet.getInt("del_mark"));

        }
        return livein;
    }

    @Override
    public Livein selectByUserId(String userId) throws Exception {
        return null;
    }

}
