package com.hhu.domain.entity;

public class RoomType {
    private  Long pk = System.currentTimeMillis();
    private  String id; //房间类型编号
    private  String rType;//房间类型
    private  String bed;//床位数
    private  Double price;//单价
    private  Double foregift;//押金
    private  String clRomm;//是否钟点房
    private  Double clPrice;//钟点房价格
    private  String remark;//备注
    private  Integer sysmark;
    private  Integer delMark;

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

    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getForegift() {
        return foregift;
    }

    public void setForegift(Double foregift) {
        this.foregift = foregift;
    }

    public String getClRomm() {
        return clRomm;
    }

    public void setClRomm(String clRomm) {
        this.clRomm = clRomm;
    }

    public Double getClPrice() {
        return clPrice;
    }

    public void setClPrice(Double clPrice) {
        this.clPrice = clPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSysmark() {
        return sysmark;
    }

    public void setSysmark(Integer sysmark) {
        this.sysmark = sysmark;
    }

    public Integer getDelMark() {
        return delMark;
    }

    public void setDelMark(Integer delMark) {
        this.delMark = delMark;
    }
}
