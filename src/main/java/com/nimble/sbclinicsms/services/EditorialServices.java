package com.nimble.sbclinicsms.services;

import com.nimble.sbclinicsms.data.model.Clinic;
import com.nimble.sbclinicsms.data.model.Editorial;
import com.nimble.sbclinicsms.data.vo.v1.EditorialVO;
import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.parser.DozerParser;
import com.nimble.sbclinicsms.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EditorialServices {

    @Autowired
    private EditorialRepository repository;

    public EditorialVO create(EditorialVO editorial) {

        var entity = DozerParser.parseObject(editorial, Editorial.class);
        return DozerParser.parseObject(repository.save(entity), EditorialVO.class);
    }

    public List<EditorialVO> findAll() {
        return DozerParser.parseListObjects(repository.findAll(), EditorialVO.class);
    }

    public List<EditorialVO> findAllByClinicIdAndSection(Long clinicId, String section) {
        return DozerParser.parseListObjects(repository.findAllByClinicIdAndSection(clinicId, section), EditorialVO.class);
    }

    public EditorialVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, EditorialVO.class);
    }

    public List<EditorialVO> findByClinicId(Long clinicId) {
        return DozerParser.parseListObjects(repository.findByClinicId(clinicId), EditorialVO.class);
    }

    public List<EditorialVO> findBySection(String section) {
        return DozerParser.parseListObjects(repository.findBySection(section), EditorialVO.class);
    }

    public EditorialVO update(EditorialVO editorial) {
        var entity = repository.findById(editorial.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setSection(editorial.getSection());
        entity.setClinic(DozerParser.parseObject(editorial.getClinic(), Clinic.class));
        entity.setParent(DozerParser.parseObject(editorial.getParent(), Editorial.class));

        return DozerParser.parseObject(repository.save(entity), EditorialVO.class);
    }

    public void delete(Long id) {
        Editorial entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
