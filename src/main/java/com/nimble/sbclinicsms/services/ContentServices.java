package com.nimble.sbclinicsms.services;

import com.nimble.sbclinicsms.data.model.Content;
import com.nimble.sbclinicsms.data.vo.v1.ContentLightVO;
import com.nimble.sbclinicsms.data.vo.v1.ContentVO;
import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.parser.DozerParser;
import com.nimble.sbclinicsms.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContentServices {

    @Autowired
    private ContentRepository repository;

    public ContentVO create(ContentVO content) {

        var entity = DozerParser.parseObject(content, Content.class);
        return DozerParser.parseObject(repository.save(entity), ContentVO.class);
    }

    public List<ContentVO> findAll() {
        return DozerParser.parseListObjects(repository.findAll(), ContentVO.class);
    }

    public List<ContentLightVO> findAllByEditorialIdAndLanguage(Long editorialId, String language) {
        List<Content> contents = new ArrayList<>();
        repository.findAllByEditorialIdAndLanguage(editorialId, "it").forEach(c -> {
            if (repository.findAllBySlugAndLanguage(c.getSlug(), "en").isEmpty()) {
                contents.add(c);
            }
            else {
                contents.add(repository.findAllBySlugAndLanguage(c.getSlug(), language).get(0));
            }
        });
        return DozerParser.parseListObjects(contents, ContentLightVO.class);
    }

    public ContentVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, ContentVO.class);
    }

    public ContentVO update(ContentVO content) {
        var entity = repository.findById(content.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setTitle(content.getTitle());
        entity.setSlug(content.getSlug());
        entity.setEditorial(content.getEditorial());
        entity.setDescription(content.getDescription());
        entity.setBody(content.getBody());
        entity.setLanguage(content.getLanguage());

        return DozerParser.parseObject(repository.save(entity), ContentVO.class);
    }

    public void delete(Long id) {
        Content entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
