package com.nimble.sbclinicsms.repository;

import com.nimble.sbclinicsms.data.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
    List<Editorial> findBySection(String section);
    List<Editorial> findByClinicId(Long clinicId);
    List<Editorial> findAllByClinicIdAndSection(Long clinicId, String section);
}
