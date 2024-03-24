package com.hhu.domain.entity;
import java.util.UUID;

/**
 * @Author:xjl
 * @version 1.0
 * @data 2024-3-19
 */
public class Pwd {
    private Long pk=System.currentTimeMillis();//序列号
    private String userId;//账号
    private String pwd;//密码
    private String puis;//权限
    private int delmark=0;//删除标记

    public Pwd() {
    }
    /**
     * 有参构造
     * @param userId
     * @param pwd
     * @param puis
     */
    public Pwd(String userId, String pwd, String puis) {
        this.userId = userId;
        this.pwd = pwd;
        this.puis = puis;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPuis() {
        return puis;
    }

    public void setPuis(String puis) {
        this.puis = puis;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }

    @Override
    public String toString() {
        return "Pwd{" +
                "pk=" + pk +
                ", userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", puis='" + puis + '\'' +
                ", delmark=" + delmark +
                '}';
    }
}
