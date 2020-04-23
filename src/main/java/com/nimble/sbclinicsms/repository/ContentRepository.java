package com.nimble.sbclinicsms.repository;

import com.nimble.sbclinicsms.data.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    List<Content> findAllByEditorialIdAndLanguage(Long editorialId, String language);
    List<Content> findAllBySlugAndLanguage(String slug, String language);
}
