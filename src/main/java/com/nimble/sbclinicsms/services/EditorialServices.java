package com.nimble.sbclinicsms.services;

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

    public EditorialVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, EditorialVO.class);
    }

    public EditorialVO update(EditorialVO editorial) {
        var entity = repository.findById(editorial.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setSection(editorial.getSection());
        entity.setClinicId(editorial.getClinicId());
        entity.setParentId(editorial.getParentId());

        return DozerParser.parseObject(repository.save(entity), EditorialVO.class);
    }

    public void delete(Long id) {
        Editorial entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
