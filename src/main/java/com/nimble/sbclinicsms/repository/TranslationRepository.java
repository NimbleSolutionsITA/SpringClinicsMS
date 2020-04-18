package com.nimble.sbclinicsms.repository;

import com.nimble.sbclinicsms.data.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Long> {
}
