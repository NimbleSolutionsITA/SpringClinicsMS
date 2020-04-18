package com.nimble.sbclinicsms.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="media")
public class Media implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String title;
    @Column(length = 100)
    private String slug;
    @Column(nullable = false, name="editorial_id")
    private Long editorialId;
    @Column(nullable = false, length = 100)
    private String type;
    @Column(nullable = false)
    private String url;
    @Column(length = 10)
    private String language;

    public Media() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(getId(), media.getId()) &&
                Objects.equals(getTitle(), media.getTitle()) &&
                Objects.equals(getSlug(), media.getSlug()) &&
                Objects.equals(getEditorialId(), media.getEditorialId()) &&
                Objects.equals(getType(), media.getType()) &&
                Objects.equals(getUrl(), media.getUrl()) &&
                Objects.equals(getLanguage(), media.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSlug(), getEditorialId(), getType(), getUrl(), getLanguage());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
