package com.hhu.domain.entity;

import com.hhu.util.JDBCUtil;

import static com.hhu.util.JDBCUtil.*;

public class Record {
    private Long pk = System.currentTimeMillis();
    private String time;
    private String operator;
    private String brief;
    private String content;
    private Integer delmark = 0;

    public Record(){}

    public Record(String time, String operator, String brief, String content) {
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

    public void insert(Record record) {
        String sql = "insert into record values(?,?,?,?,?,?,?)";
        JDBCUtil.update(sql, record.getPk(), record.getTime(), record.getOperator(), record.getBrief(), record.getContent(), record.getDelmark());


    }
}
