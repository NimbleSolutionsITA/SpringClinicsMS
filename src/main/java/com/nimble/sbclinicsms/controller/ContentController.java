package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.v1.ContentVO;
import com.nimble.sbclinicsms.services.ContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/content/v1")
public class ContentController {

    @Autowired
    private ContentServices service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<ContentVO> findAll() {
        List<ContentVO> contents = service.findAll();
        contents.forEach(p -> {
            p.add(linkTo(methodOn(ContentController.class).findById(p.getKey())).withSelfRel());
            p.add(linkTo(methodOn(EditorialController.class).findById(p.getEditorial().getId())).withRel("editorial"));
        });
        return contents;
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ContentVO findById(@PathVariable("id") Long id) {
        ContentVO contentVO = service.findById(id);
        contentVO.add(linkTo(methodOn(ContentController.class).findById(id)).withSelfRel());
        contentVO.add(linkTo(methodOn(EditorialController.class).findById(contentVO.getEditorial().getId())).withRel("editorial"));
        return contentVO;
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ContentVO create(@RequestBody ContentVO content) {
        ContentVO contentVO = service.create(content);
        content.add(linkTo(methodOn(ContentController.class).findById(contentVO.getKey())).withSelfRel());
        content.add(linkTo(methodOn(EditorialController.class).findById(contentVO.getEditorial().getId())).withRel("editorial"));
        return content;
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ContentVO update(@RequestBody ContentVO content) {
        ContentVO contentVO = service.update(content);
        content.add(linkTo(methodOn(ContentController.class).findById(contentVO.getKey())).withSelfRel());
        content.add(linkTo(methodOn(EditorialController.class).findById(contentVO.getEditorial().getId())).withRel("editorial"));
        return content;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
