package com.nimble.sbclinicsms.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="clinic")
public class Clinic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
    @Column(name="is_group", nullable = false)
    private Boolean isGroup;
    @Column(name="group_id")
    private Long groupId;
    @Column(nullable = false, length = 10)
    private String logo;
    @Column(name="google_place_id", nullable = false)
    private String googlePlaceId;

    public Clinic() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(getId(), clinic.getId()) &&
                Objects.equals(getName(), clinic.getName()) &&
                Objects.equals(isGroup, clinic.isGroup) &&
                Objects.equals(getGroupId(), clinic.getGroupId()) &&
                Objects.equals(getLogo(), clinic.getLogo()) &&
                Objects.equals(getGooglePlaceId(), clinic.getGooglePlaceId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), isGroup, getGroupId(), getLogo(), getGooglePlaceId());
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

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
}
