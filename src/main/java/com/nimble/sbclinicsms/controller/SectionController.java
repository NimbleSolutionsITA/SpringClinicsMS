package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.v1.EditorialVO;
import com.nimble.sbclinicsms.data.vo.v1.SectionVO;
import com.nimble.sbclinicsms.services.EditorialServices;
import com.nimble.sbclinicsms.services.MediaServices;
import com.nimble.sbclinicsms.services.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/section/v1")
public class SectionController {

    @Autowired
    private EditorialServices editorialService;
    @Autowired
    private ContentServices contentService;
    @Autowired
    private MediaServices mediaService;

    private SectionVO initSectionVO(Long clinicId, String section, String language)  {
        SectionVO sectionVO = new SectionVO();
        Long editorialId = editorialService.findAllByClinicIdAndSection(clinicId, section).get(0).getKey();
        sectionVO.setSection(section);
        sectionVO.setContents(contentService.findAllByEditorialIdAndLanguage(editorialId, language));
        sectionVO.setMedias(mediaService.findAllByEditorialIdAndLanguage(editorialId, language));
        sectionVO.getContents().forEach(c -> c.add(linkTo(methodOn(ContentController.class).findById(c.getKey())).withSelfRel()));
        sectionVO.getMedias().forEach(m -> m.add(linkTo(methodOn(MediaController.class).findById(m.getKey())).withSelfRel()));
        return sectionVO;
    }

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<SectionVO> findAll(
            @RequestHeader("clinic-id") Long clinicId,
            @RequestHeader(value = "language", defaultValue = "it") String language) {
        List<SectionVO> sections = new ArrayList<>();
        List<EditorialVO> editorials = editorialService.findByClinicId(clinicId);
        editorials.forEach(e -> {
            sections.add(initSectionVO(clinicId, e.getSection(), language));
        });
        return sections;
    }

    @GetMapping(
            value = "/{section}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public SectionVO findBySection(
            @PathVariable("section") String section,
            @RequestHeader("clinic-id") Long clinicId,
            @RequestHeader(value = "language", defaultValue = "it") String language) {
        return initSectionVO(clinicId, section, language);
    }
}
