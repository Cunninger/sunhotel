package com.hhu.domain.entity;

public class Member {
    private Long pk=System.currentTimeMillis();//序列号
    private String mId;//会员编号
    private String mName;//会员姓名
    private String sex;//会员性别
    private String zjNo;//证件编号
    private String mTel;//联系电话
    private String address;//详细地址
    private String remark;//备注
    private Integer delmark=0;

    public Member() {
    }

    public Member(String pk, String mId, String mName, String sex, String zjNo, String mTel, String address, String remark) {
        this.mId = mId;
        this.mName = mName;
        this.sex = sex;
        this.zjNo = zjNo;
        this.mTel = mTel;
        this.address = address;
        this.remark = remark;
        this.pk=Long.parseLong(pk);

    }

    public Long getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk =Long.parseLong( pk);
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getZjNo() {
        return zjNo;
    }

    public void setZjNo(String zjNo) {
        this.zjNo = zjNo;
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "MemberDao{" +
                "pk=" + pk +
                ", mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", sex='" + sex + '\'' +
                ", zjNo='" + zjNo + '\'' +
                ", mTel='" + mTel + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", delmark=" + delmark +
                '}';
    }
}
