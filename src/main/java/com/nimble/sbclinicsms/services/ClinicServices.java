package com.nimble.sbclinicsms.services;

import java.util.List;

import com.nimble.sbclinicsms.parser.DozerParser;
import com.nimble.sbclinicsms.data.vo.v1.ClinicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.data.model.Clinic;
import com.nimble.sbclinicsms.repository.ClinicRepository;


@Service
public class ClinicServices {

    @Autowired
    private ClinicRepository repository;

    public ClinicVO create(ClinicVO clinic) {

        var entity = DozerParser.parseObject(clinic, Clinic.class);
        return DozerParser.parseObject(repository.save(entity), ClinicVO.class);
    }

    public List<ClinicVO> findAll() {
        return DozerParser.parseListObjects(repository.findAll(), ClinicVO.class);
    }

    public ClinicVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, ClinicVO.class);
    }

    public ClinicVO update(ClinicVO clinic) {
        var entity = repository.findById(clinic.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setName(clinic.getName());
        entity.setLogo(clinic.getLogo());
        entity.setGroup(clinic.getGroup());
        entity.setGooglePlaceId(clinic.getGooglePlaceId());

        return DozerParser.parseObject(repository.save(entity), ClinicVO.class);
    }

    public void delete(Long id) {
        Clinic entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
