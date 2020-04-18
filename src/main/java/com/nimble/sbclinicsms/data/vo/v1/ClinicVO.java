package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "name" })
public class ClinicVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String name;
    private Boolean isGroup;
    private Long groupId;
    private String logo;
    private String googlePlaceId;

    public ClinicVO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClinicVO clinicVO = (ClinicVO) o;
        return Objects.equals(getKey(), clinicVO.getKey()) &&
                Objects.equals(getName(), clinicVO.getName()) &&
                Objects.equals(isGroup, clinicVO.isGroup) &&
                Objects.equals(getGroupId(), clinicVO.getGroupId()) &&
                Objects.equals(getLogo(), clinicVO.getLogo()) &&
                Objects.equals(getGooglePlaceId(), clinicVO.getGooglePlaceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getName(), isGroup, getGroupId(), getLogo(), getGooglePlaceId());
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
}
