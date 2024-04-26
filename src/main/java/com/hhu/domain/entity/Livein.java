package com.hhu.domain.entity;

import java.math.BigDecimal;

public class Livein {
    private BigDecimal pk= BigDecimal.valueOf(System.currentTimeMillis());
    private String inNo;
    private String rNo;
    private String rTypeId;
    private String mainRoom;



    private String mainPk;
    private String cTypeId;
    private String cName;
    private String cJp;
    private String sex;
    private String zjType;
    private String zjNo;
    private String address;
    private Integer renshu;
    private String inTime;
    private Double account;
    private Integer days;
    private Double foregift;
    private String remark;
    private String mId;
    private String chkNo;
    private String chkTime;
    private String userId;
    private String statemark;
    private Integer cluemark;
    private Integer delmark;

    public Livein(String inNo, String rNo, String rTypeId, String mainRoom,String mainPk, String cTypeId, String cName, String cJp, String sex, String zjType, String zjNo, String address, Integer renshu, Double account, Integer days, Double foregift, String remark, String mId, String chkNo, String chkTime, String userId, String statemark, Integer cluemark, Integer delmark) {
        this.inNo = inNo;
        this.rNo = rNo;
        this.rTypeId = rTypeId;
        this.mainRoom=mainRoom;
        this.mainPk = mainPk;
        this.cTypeId = cTypeId;
        this.cName = cName;
        this.cJp = cJp;
        this.sex = sex;
        this.zjType = zjType;
        this.zjNo = zjNo;
        this.address = address;
        this.renshu = renshu;
        this.account = account;
        this.days = days;
        this.foregift = foregift;
        this.remark = remark;
        this.mId = mId;
        this.chkNo = chkNo;
        this.chkTime = chkTime;
        this.userId = userId;
        this.statemark = statemark;
        this.cluemark = cluemark;
        this.delmark = delmark;
    }

    public Livein() {
    }

    public BigDecimal getPk() {
        return pk;
    }

    public void setPk(BigDecimal pk) {
        this.pk = pk;
    }

    public String getInNo() {
        return inNo;
    }

    public void setInNo(String inNo) {
        this.inNo = inNo;
    }

    public String getrNo() {
        return rNo;
    }

    public void setrNo(String rNo) {
        this.rNo = rNo;
    }

    public String getrTypeId() {
        return rTypeId;
    }

    public void setrTypeId(String rTypeId) {
        this.rTypeId = rTypeId;
    }
    public String getMainRoom() {
        return mainRoom;
    }

    public void setMainRoom(String mainRoom) {
        this.mainRoom = mainRoom;
    }
    public String getMainPk() {
        return mainPk;
    }

    public void setMainPk(String mainPk) {
        this.mainPk = mainPk;
    }

    public String getcTypeId() {
        return cTypeId;
    }

    public void setcTypeId(String cTypeId) {
        this.cTypeId = cTypeId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcJp() {
        return cJp;
    }

    public void setcJp(String cJp) {
        this.cJp = cJp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZjType() {
        return zjType;
    }

    public void setZjType(String zjType) {
        this.zjType = zjType;
    }

    public String getZjNo() {
        return zjNo;
    }

    public void setZjNo(String zjNo) {
        this.zjNo = zjNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRenshu() {
        return renshu;
    }

    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = String.valueOf(inTime);
    }

    public Double getAccount() {
        return account;
    }

    public void setAccount(Double account) {
        this.account = account;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getForegift() {
        return foregift;
    }

    public void setForegift(Double foregift) {
        this.foregift = foregift;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getChkNo() {
        return chkNo;
    }

    public void setChkNo(String chkNo) {
        this.chkNo = chkNo;
    }

    public String getChkTime() {
        return chkTime;
    }

    public void setChkTime(String chkTime) {
        this.chkTime = chkTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatemark() {
        return statemark;
    }

    public void setStatemark(String statemark) {
        this.statemark = statemark;
    }

    public Integer getCluemark() {
        return cluemark;
    }

    public void setCluemark(Integer cluemark) {
        this.cluemark = cluemark;
    }

    public Integer getDelmark() {
        return delmark;
    }

    public void setDelmark(Integer delmark) {
        this.delmark = delmark;
    }
    // toString
    @Override
    public String toString() {
        return "Classname{" +
                "pk=" + pk +
                ", inNo='" + inNo + '\'' +
                ", rNo='" + rNo + '\'' +
                ", rTypeId='" + rTypeId + '\'' +
                ", mainRoom='" + mainRoom + '\'' +
                ", mainPk='" + mainPk + '\'' +
                ", cTypeId='" + cTypeId + '\'' +
                ", cName='" + cName + '\'' +
                ", cJp='" + cJp + '\'' +
                ", sex='" + sex + '\'' +
                ", zjType='" + zjType + '\'' +
                ", zjNo='" + zjNo + '\'' +
                ", address='" + address + '\'' +
                ", renshu=" + renshu +
                ", inTime=" + inTime +
                ", account=" + account +
                ", days=" + days +
                ", foregift=" + foregift +
                ", remark='" + remark + '\'' +
                ", mId='" + mId + '\'' +
                ", chkNo='" + chkNo + '\'' +
                ", chkTime='" + chkTime + '\'' +
                ", userId='" + userId + '\'' +
                ", statemark='" + statemark + '\'' +
                ", cluemark=" + cluemark +
                ", delmark=" + delmark +
                '}';
    }

}
