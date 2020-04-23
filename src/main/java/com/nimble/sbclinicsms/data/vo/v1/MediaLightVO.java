package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import com.nimble.sbclinicsms.data.model.Editorial;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({ "id", "editorialId", "slug", "type", "title", "url", "language" })
public class MediaLightVO extends RepresentationModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    @JsonProperty("id")

    private Long key;

    private String title;
    private String slug;
    private String url;
    private String type;

    public MediaLightVO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MediaLightVO that = (MediaLightVO) o;
        return Objects.equals(getKey(), that.getKey()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getSlug(), that.getSlug()) &&
                Objects.equals(getUrl(), that.getUrl()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getTitle(), getSlug(), getUrl(), getType());
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
}
