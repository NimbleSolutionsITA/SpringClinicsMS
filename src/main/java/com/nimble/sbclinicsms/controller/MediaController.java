package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.v1.MediaVO;
import com.nimble.sbclinicsms.services.MediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/media/v1")
public class MediaController {

    @Autowired
    private MediaServices service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<MediaVO> findAll() {
        List<MediaVO> medias = service.findAll();
        medias.forEach(p -> {
            p.add(linkTo(methodOn(MediaController.class).findById(p.getKey())).withSelfRel());
            p.add(linkTo(methodOn(EditorialController.class).findById(p.getEditorial().getId())).withRel("editorial"));
        });
        return medias;
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public MediaVO findById(@PathVariable("id") Long id) {
        MediaVO mediaVO = service.findById(id);
        mediaVO.add(linkTo(methodOn(MediaController.class).findById(id)).withSelfRel());
        mediaVO.add(linkTo(methodOn(EditorialController.class).findById(mediaVO.getEditorial().getId())).withRel("editorial"));
        return mediaVO;
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MediaVO create(@RequestBody MediaVO media) {
        MediaVO mediaVO = service.create(media);
        media.add(linkTo(methodOn(MediaController.class).findById(mediaVO.getKey())).withSelfRel());
        media.add(linkTo(methodOn(EditorialController.class).findById(mediaVO.getEditorial().getId())).withRel("editorial"));
        return media;
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public MediaVO update(@RequestBody MediaVO media) {
        MediaVO mediaVO = service.update(media);
        media.add(linkTo(methodOn(MediaController.class).findById(mediaVO.getKey())).withSelfRel());
        media.add(linkTo(methodOn(EditorialController.class).findById(mediaVO.getEditorial().getId())).withRel("editorial"));
        return media;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
