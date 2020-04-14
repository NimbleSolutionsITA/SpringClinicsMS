package com.nimble.sbclinicsms.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class ClinicVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private Boolean isGroup;
    private Long groupId;
    private String logo;
    private String address;
    private String latitude;
    private String longitude;
    private String businessName;
    private String businessAddress;
    private String taxNumber;
    private String fiscalCode;
    private String shareCapital;

    public ClinicVO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGroup() {
        return isGroup;
    }

    public void setGroup(Boolean group) {
        isGroup = group;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getShareCapital() {
        return shareCapital;
    }

    public void setShareCapital(String shareCapital) {
        this.shareCapital = shareCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicVO clinicVO = (ClinicVO) o;
        return Objects.equals(getId(), clinicVO.getId()) &&
                Objects.equals(getName(), clinicVO.getName()) &&
                Objects.equals(isGroup, clinicVO.isGroup) &&
                Objects.equals(getGroupId(), clinicVO.getGroupId()) &&
                Objects.equals(getLogo(), clinicVO.getLogo()) &&
                Objects.equals(getAddress(), clinicVO.getAddress()) &&
                Objects.equals(getLatitude(), clinicVO.getLatitude()) &&
                Objects.equals(getLongitude(), clinicVO.getLongitude()) &&
                Objects.equals(getBusinessName(), clinicVO.getBusinessName()) &&
                Objects.equals(getBusinessAddress(), clinicVO.getBusinessAddress()) &&
                Objects.equals(getTaxNumber(), clinicVO.getTaxNumber()) &&
                Objects.equals(getFiscalCode(), clinicVO.getFiscalCode()) &&
                Objects.equals(getShareCapital(), clinicVO.getShareCapital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), isGroup, getGroupId(), getLogo(), getAddress(), getLatitude(), getLongitude(), getBusinessName(), getBusinessAddress(), getTaxNumber(), getFiscalCode(), getShareCapital());
    }
}
