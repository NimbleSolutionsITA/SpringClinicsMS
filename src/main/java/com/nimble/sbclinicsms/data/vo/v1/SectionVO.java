package com.nimble.sbclinicsms.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.nimble.sbclinicsms.services.ContentServices;
import com.nimble.sbclinicsms.services.EditorialServices;
import com.nimble.sbclinicsms.services.MediaServices;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ "id", "section", "contents", "medias" })
public class SectionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String section;
    private List<ContentLightVO> contents;
    private List<MediaLightVO> medias;

    public SectionVO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionVO sectionVO = (SectionVO) o;
        return Objects.equals(getSection(), sectionVO.getSection()) &&
                Objects.equals(getContents(), sectionVO.getContents()) &&
                Objects.equals(getMedias(), sectionVO.getMedias());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSection(), getContents(), getMedias());
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<ContentLightVO> getContents() {
        return contents;
    }

    public void setContents(List<ContentLightVO> contents) {
        this.contents = contents;
    }

    public List<MediaLightVO> getMedias() {
        return medias;
    }

    public void setMedias(List<MediaLightVO> medias) {
        this.medias = medias;
    }
}
