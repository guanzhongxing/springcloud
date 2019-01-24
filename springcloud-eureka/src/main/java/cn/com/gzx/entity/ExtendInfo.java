package cn.com.gzx.entity;

import java.util.Date;

public class ExtendInfo {

    private String applyPolicyNo;

    private String isBeforePayFee;

    private String mark;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    public String getApplyPolicyNo() {
        return applyPolicyNo;
    }

    public void setApplyPolicyNo(String applyPolicyNo) {
        this.applyPolicyNo = applyPolicyNo;
    }

    public String getIsBeforePayFee() {
        return isBeforePayFee;
    }

    public void setIsBeforePayFee(String isBeforePayFee) {
        this.isBeforePayFee = isBeforePayFee;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
