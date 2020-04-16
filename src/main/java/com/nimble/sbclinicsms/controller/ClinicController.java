package com.nimble.sbclinicsms.controller;

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
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO create(@RequestBody ClinicVO clinic) {
        return service.create(clinic);
    }

    @PutMapping(
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ClinicVO update(@RequestBody ClinicVO clinic) {
        return service.update(clinic);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
