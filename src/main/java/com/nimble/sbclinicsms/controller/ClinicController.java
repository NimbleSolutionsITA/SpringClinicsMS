package com.nimble.sbclinicsms.controller;

import com.nimble.sbclinicsms.model.Clinic;
import com.nimble.sbclinicsms.services.ClinicServices;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    private final ClinicServices services = new ClinicServices();

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Clinic> findAll() {
        return services.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinic findById(@PathVariable("id") Long id) {
        return services.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinic create(@RequestBody Clinic clinic) {
        return services.create(clinic);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Clinic update(@RequestBody Clinic clinic) {
        return services.update(clinic);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        services.delete(id);
    }

    @RequestMapping(value = "/initialize", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void initialize() {
        Clinic ghc = services.mockGHC();

        int i = 0;
        while (i < 30) {
            services.mockClinic(ghc.getId());
            i++;
        }
    }

}
