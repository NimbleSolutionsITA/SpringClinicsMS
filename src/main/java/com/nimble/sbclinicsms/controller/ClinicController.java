package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.data.vo.ClinicVO;
import com.nimble.sbclinicsms.services.ClinicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    private ClinicServices service;

    @GetMapping
    public List<ClinicVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public ClinicVO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ClinicVO create(@RequestBody ClinicVO clinic) {
        return service.create(clinic);
    }

    @PutMapping
    public ClinicVO update(@RequestBody ClinicVO clinic) {
        return service.update(clinic);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
