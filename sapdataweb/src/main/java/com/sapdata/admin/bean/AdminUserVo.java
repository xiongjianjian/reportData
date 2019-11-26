package com.sapdata.admin.bean;

import java.util.Date;
import java.util.List;

public class AdminUserVo {
    private Long userId;

    private String customerCode;

    private String customerPassword;

    private String saleCode;

    private String salePassword;

    private String mobile;

    private String realName;

    private String idcard;

    private String address;

    private Date createDate;

    private Date modifyDate;

    private Integer roleCode;

    private Integer loginMode;

    private Integer pageNo;

    private Integer pageSize;

    private Integer lastPage;

    private List list;//存储返回列表

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer total, Integer pageSize) {
        if (total % pageSize == 0) {
            this.lastPage = total / pageSize;
        } else {
            this.lastPage = total / pageSize + 1;
        }
    }

    private Integer total;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword == null ? null : customerPassword.trim();
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode == null ? null : saleCode.trim();
    }

    public String getSalePassword() {
        return salePassword;
    }

    public void setSalePassword(String salePassword) {
        this.salePassword = salePassword == null ? null : salePassword.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getLoginMode() {
        return loginMode;
    }

    public void setLoginMode(Integer loginMode) {
        this.loginMode = loginMode;
    }
}