package com.hhu.domain.entity;
import java.util.Date;
public class Recod {
    private Long pk=System.currentTimeMillis();//序列号
    private String time;//时间
    private String operator;//操作人
    private String brief;//简介
    private String content;//内容
    private Integer delmark;
    public Recod() {
    }
    public Recod(String time, String operator, String brief, String content) {
        this.time = time;
        this.operator = operator;
        this.brief = brief;
        this.content = content;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
}
