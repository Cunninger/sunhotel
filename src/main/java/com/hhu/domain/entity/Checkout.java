package com.hhu.domain.entity;

import java.time.LocalDateTime;

public class Checkout {
    private Long pk=System.currentTimeMillis();//序列号
    private String chk_no;//结算单号
    private String in_no;//入住单号
    private Integer days;//入住天数
    private Double money;//总金额
    private LocalDateTime chk_time;//结算时间
    private String remark;//备注
    private Integer delmark=0;//删除标记

    public Checkout() {
    }

    public Checkout(String chk_no, String in_no, Integer days, Double money, LocalDateTime chk_time, String remark, Integer delmark) {
        this.chk_no = chk_no;
        this.in_no = in_no;
        this.days = days;
        this.money = money;
        this.chk_time = chk_time;
        this.remark = remark;
        this.delmark = delmark;
    }

    public String getChk_no() {
        return chk_no;
    }

    public void setChk_no(String chk_no) {
        this.chk_no = chk_no;
    }

    public String getIn_no() {
        return in_no;
    }

    public void setIn_no(String in_no) {
        this.in_no = in_no;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getChk_time() {
        return chk_time;
    }

    public void setChk_time(LocalDateTime chk_time) {
        this.chk_time = chk_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}
