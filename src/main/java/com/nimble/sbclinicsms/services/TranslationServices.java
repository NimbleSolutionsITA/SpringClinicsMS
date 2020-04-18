package com.nimble.sbclinicsms.services;

import com.nimble.sbclinicsms.data.model.Translation;
import com.nimble.sbclinicsms.data.vo.v1.TranslationVO;
import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.parser.DozerParser;
import com.nimble.sbclinicsms.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TranslationServices {

    @Autowired
    private TranslationRepository repository;

    public TranslationVO create(TranslationVO translation) {

        var entity = DozerParser.parseObject(translation, Translation.class);
        return DozerParser.parseObject(repository.save(entity), TranslationVO.class);
    }

    public List<TranslationVO> findAll() {
        return DozerParser.parseListObjects(repository.findAll(), TranslationVO.class);
    }

    public TranslationVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, TranslationVO.class);
    }

    public TranslationVO update(TranslationVO translation) {
        var entity = repository.findById(translation.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setTitle(translation.getTitle());
        entity.setSlug(translation.getSlug());
        entity.setEditorialId(translation.getEditorialId());
        entity.setDescription(translation.getDescription());
        entity.setBody(translation.getBody());
        entity.setLanguage(translation.getLanguage());

        return DozerParser.parseObject(repository.save(entity), TranslationVO.class);
    }

    public void delete(Long id) {
        Translation entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
