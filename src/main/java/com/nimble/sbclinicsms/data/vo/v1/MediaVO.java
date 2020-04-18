package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "editorialId", "slug", "type", "title", "url", "language" })
public class MediaVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String title;
    private String slug;
    private Long editorialId;
    private String url;
    private String type;
    private String language;

    public MediaVO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MediaVO mediaVO = (MediaVO) o;
        return Objects.equals(getKey(), mediaVO.getKey()) &&
                Objects.equals(getTitle(), mediaVO.getTitle()) &&
                Objects.equals(getSlug(), mediaVO.getSlug()) &&
                Objects.equals(getEditorialId(), mediaVO.getEditorialId()) &&
                Objects.equals(getUrl(), mediaVO.getUrl()) &&
                Objects.equals(getType(), mediaVO.getType()) &&
                Objects.equals(getLanguage(), mediaVO.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getTitle(), getSlug(), getEditorialId(), getUrl(), getType(), getLanguage());
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

    public Long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Long editorialId) {
        this.editorialId = editorialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
