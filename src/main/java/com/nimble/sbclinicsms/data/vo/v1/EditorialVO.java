package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "section", "clinic_id", "parent_id" })
public class EditorialVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String section;
    private Long clinicId;
    private Long parentId;

    public EditorialVO() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EditorialVO that = (EditorialVO) o;
        return Objects.equals(getKey(), that.getKey()) &&
                Objects.equals(getSection(), that.getSection()) &&
                Objects.equals(getClinicId(), that.getClinicId()) &&
                Objects.equals(getParentId(), that.getParentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getSection(), getClinicId(), getParentId());
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
