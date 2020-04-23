package com.nimble.sbclinicsms.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.nimble.sbclinicsms.data.vo.v1.ClinicVO;
import com.nimble.sbclinicsms.services.ClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinic/v1")
public class ClinicController {

    @Autowired
    private ClinicServices service;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<ClinicVO> findAll() {
        List<ClinicVO> clinics = service.findAll();
        clinics.forEach(p -> {
            p.add(linkTo(methodOn(ClinicController.class).findById(p.getKey())).withSelfRel());
            if(p.getParentGroup() != null) {
                p.add(linkTo(methodOn(ClinicController.class).findById(p.getParentGroup().getId())).withRel("group"));
            }
        });
        return clinics;
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO findById(@PathVariable("id") Long id) {
        ClinicVO clinicVO = service.findById(id);
        clinicVO.add(linkTo(methodOn(ClinicController.class).findById(id)).withSelfRel());
        if(clinicVO.getParentGroup() != null) {
            clinicVO.add(linkTo(methodOn(ClinicController.class).findById(clinicVO.getParentGroup().getId())).withRel("group"));
        }
        return clinicVO;
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO create(@RequestBody ClinicVO clinic) {
        ClinicVO clinicVO = service.create(clinic);
        clinic.add(linkTo(methodOn(ClinicController.class).findById(clinicVO.getKey())).withSelfRel());
        return clinic;
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO update(@RequestBody ClinicVO clinic) {
        ClinicVO clinicVO = service.update(clinic);
        clinic.add(linkTo(methodOn(ClinicController.class).findById(clinicVO.getKey())).withSelfRel());
        return clinic;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
