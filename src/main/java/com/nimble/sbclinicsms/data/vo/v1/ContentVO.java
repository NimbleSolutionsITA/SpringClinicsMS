package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import com.nimble.sbclinicsms.data.model.Editorial;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "editorialId", "slug", "language", "title", "description", "body" })
public class ContentVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String title;
    private String slug;
    private Editorial editorial;
    private String description;
    private String body;
    private String language;

    public ContentVO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContentVO that = (ContentVO) o;
        return Objects.equals(getKey(), that.getKey()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getSlug(), that.getSlug()) &&
                Objects.equals(getEditorial(), that.getEditorial()) &&
                Objects.equals(getDescription(), that.getDescription()) &&
                Objects.equals(getBody(), that.getBody()) &&
                Objects.equals(getLanguage(), that.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getTitle(), getSlug(), getEditorial(), getDescription(), getBody(), getLanguage());
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
