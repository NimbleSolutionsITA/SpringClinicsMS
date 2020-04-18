package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.v1.TranslationVO;
import com.nimble.sbclinicsms.services.TranslationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/translation/v1")
public class TranslationController {

    @Autowired
    private TranslationServices service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<TranslationVO> findAll() {
        List<TranslationVO> translations = service.findAll();
        translations.forEach(p -> {
            p.add(linkTo(methodOn(TranslationController.class).findById(p.getKey())).withSelfRel());
            p.add(linkTo(methodOn(EditorialController.class).findById(p.getEditorialId())).withRel("editorial"));
        });
        return translations;
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public TranslationVO findById(@PathVariable("id") Long id) {
        TranslationVO translationVO = service.findById(id);
        translationVO.add(linkTo(methodOn(TranslationController.class).findById(id)).withSelfRel());
        translationVO.add(linkTo(methodOn(EditorialController.class).findById(translationVO.getEditorialId())).withRel("editorial"));
        return translationVO;
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public TranslationVO create(@RequestBody TranslationVO translation) {
        TranslationVO translationVO = service.create(translation);
        translation.add(linkTo(methodOn(TranslationController.class).findById(translationVO.getKey())).withSelfRel());
        translation.add(linkTo(methodOn(EditorialController.class).findById(translationVO.getEditorialId())).withRel("editorial"));
        return translation;
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public TranslationVO update(@RequestBody TranslationVO translation) {
        TranslationVO translationVO = service.update(translation);
        translation.add(linkTo(methodOn(TranslationController.class).findById(translationVO.getKey())).withSelfRel());
        translation.add(linkTo(methodOn(EditorialController.class).findById(translationVO.getEditorialId())).withRel("editorial"));
        return translation;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
