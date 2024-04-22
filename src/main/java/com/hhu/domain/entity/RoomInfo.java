package com.hhu.domain.entity;

public class RoomInfo {
    private Long pk;
    private String id;//房间号
    private String rTypeId;//房间类型编号
    private String state;//房间状态
    private String location; //所处位置
    private String rTel;//房间电话
    private String rmark;//备注
    private Integer stateTime;//状态计时
    private Integer indiMark;//开单标记
    private Integer delMark;

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getrTypeId() {
        return rTypeId;
    }

    public void setrTypeId(String rTypeId) {
        this.rTypeId = rTypeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getrTel() {
        return rTel;
    }

    public void setrTel(String rTel) {
        this.rTel = rTel;
    }

    public String getRmark() {
        return rmark;
    }

    public void setRmark(String rmark) {
        this.rmark = rmark;
    }

    public Integer getStateTime() {
        return stateTime;
    }

    public void setStateTime(Integer stateTime) {
        this.stateTime = stateTime;
    }

    public Integer getIndiMark() {
        return indiMark;
    }

    public void setIndiMark(Integer indiMark) {
        this.indiMark = indiMark;
    }

    public Integer getDelMark() {
        return delMark;
    }

    public void setDelMark(Integer delMark) {
        this.delMark = delMark;
    }
}
