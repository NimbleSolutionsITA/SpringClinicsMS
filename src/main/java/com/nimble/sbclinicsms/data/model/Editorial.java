package com.nimble.sbclinicsms.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="editorial")
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String section;
    @Column(name="clinic_id")
    private Long clinicId;
    @Column(name="parent_id")
    private Long parentId;

    public Editorial() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editorial editorial = (Editorial) o;
        return Objects.equals(getId(), editorial.getId()) &&
                Objects.equals(getSection(), editorial.getSection()) &&
                Objects.equals(getClinicId(), editorial.getClinicId()) &&
                Objects.equals(getParentId(), editorial.getParentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSection(), getClinicId(), getParentId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
