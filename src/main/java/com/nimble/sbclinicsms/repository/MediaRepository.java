package com.nimble.sbclinicsms.repository;

import com.nimble.sbclinicsms.data.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {
    List<Media> findAllByEditorialIdAndLanguage(Long editorialId, String language);
    List<Media> findAllBySlugAndLanguage(String slug, String language);
}
