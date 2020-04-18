package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.v1.EditorialVO;
import com.nimble.sbclinicsms.services.EditorialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/editorial/v1")
public class EditorialController {

    @Autowired
    private EditorialServices service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<EditorialVO> findAll() {
        List<EditorialVO> editorials = service.findAll();
        editorials.forEach(p -> {
            p.add(linkTo(methodOn(EditorialController.class).findById(p.getKey())).withSelfRel());
            p.add(linkTo(methodOn(ClinicController.class).findById(p.getClinicId())).withRel("clinic"));
            if(p.getParentId() != null) {
                p.add(linkTo(methodOn(EditorialController.class).findById(p.getParentId())).withRel("parent"));
            }
        });
        return editorials;
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public EditorialVO findById(@PathVariable("id") Long id) {
        EditorialVO editorialVO = service.findById(id);
        editorialVO.add(linkTo(methodOn(EditorialController.class).findById(id)).withSelfRel());
        editorialVO.add(linkTo(methodOn(ClinicController.class).findById(editorialVO.getClinicId())).withRel("clinic"));
        if(editorialVO.getParentId() != null) {
            editorialVO.add(linkTo(methodOn(EditorialController.class).findById(editorialVO.getParentId())).withRel("parent"));
        }
        return editorialVO;
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public EditorialVO create(@RequestBody EditorialVO editorial) {
        EditorialVO editorialVO = service.create(editorial);
        editorial.add(linkTo(methodOn(EditorialController.class).findById(editorialVO.getKey())).withSelfRel());
        return editorial;
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public EditorialVO update(@RequestBody EditorialVO editorial) {
        EditorialVO editorialVO = service.update(editorial);
        editorial.add(linkTo(methodOn(EditorialController.class).findById(editorialVO.getKey())).withSelfRel());
        return editorial;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
