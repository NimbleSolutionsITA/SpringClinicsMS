package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import com.nimble.sbclinicsms.data.model.Clinic;
import com.nimble.sbclinicsms.data.model.Editorial;
import com.nimble.sbclinicsms.data.model.Content;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@JsonPropertyOrder({ "id", "section", "clinic", "parent" })
public class EditorialVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String section;
    private Clinic clinic;
    private Editorial parent;

    private Set<Content> contents;

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
                Objects.equals(getClinic(), that.getClinic()) &&
                Objects.equals(getParent(), that.getParent()) &&
                Objects.equals(getContents(), that.getContents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getSection(), getClinic(), getParent(), getContents());
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

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Editorial getParent() {
        return parent;
    }

    public void setParent(Editorial parent) {
        this.parent = parent;
    }

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }
}
