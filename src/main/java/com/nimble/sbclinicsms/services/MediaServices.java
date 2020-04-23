package com.nimble.sbclinicsms.services;

import com.nimble.sbclinicsms.data.model.Content;
import com.nimble.sbclinicsms.data.model.Media;
import com.nimble.sbclinicsms.data.vo.v1.ContentLightVO;
import com.nimble.sbclinicsms.data.vo.v1.MediaLightVO;
import com.nimble.sbclinicsms.data.vo.v1.MediaVO;
import com.nimble.sbclinicsms.data.vo.v1.ContentVO;
import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.parser.DozerParser;
import com.nimble.sbclinicsms.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MediaServices {

    @Autowired
    private MediaRepository repository;

    public MediaVO create(MediaVO media) {

        var entity = DozerParser.parseObject(media, Media.class);
        return DozerParser.parseObject(repository.save(entity), MediaVO.class);
    }

    public List<MediaVO> findAll() {
        return DozerParser.parseListObjects(repository.findAll(), MediaVO.class);
    }

    public List<MediaLightVO> findAllByEditorialIdAndLanguage(Long editorialId, String language) {
        List<Media> medias = new ArrayList<>();
        repository.findAllByEditorialIdAndLanguage(editorialId, "it").forEach(m -> {
            if (repository.findAllBySlugAndLanguage(m.getSlug(), "en").isEmpty()) {
                medias.add(m);
            }
            else {
                medias.add(repository.findAllBySlugAndLanguage(m.getSlug(), language).get(0));
            }
        });
        return DozerParser.parseListObjects(medias, MediaLightVO.class);
    }

    public MediaVO findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerParser.parseObject(entity, MediaVO.class);
    }

    public MediaVO update(MediaVO media) {
        var entity = repository.findById(media.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setTitle(media.getTitle());
        entity.setSlug(media.getSlug());
        entity.setEditorial(media.getEditorial());
        entity.setType(media.getType());
        entity.setUrl(media.getUrl());
        entity.setLanguage(media.getLanguage());

        return DozerParser.parseObject(repository.save(entity), MediaVO.class);
    }

    public void delete(Long id) {
        Media entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
