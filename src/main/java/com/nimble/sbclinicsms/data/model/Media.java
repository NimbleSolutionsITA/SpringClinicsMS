package com.nimble.sbclinicsms.data.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(nullable = false, length = 100)
    private String type;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false, length = 5)
    private String language;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "editorial_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Editorial editorial;

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
                Objects.equals(getType(), media.getType()) &&
                Objects.equals(getUrl(), media.getUrl()) &&
                Objects.equals(getLanguage(), media.getLanguage()) &&
                Objects.equals(getEditorial(), media.getEditorial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getSlug(), getType(), getUrl(), getLanguage(), getEditorial());
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

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
}
