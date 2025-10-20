package com.medlink.portal.repository;

import com.medlink.portal.domain.ClientKit;
import com.medlink.portal.domain.TherapeuticCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TherapeuticCategoryRepository extends JpaRepository<TherapeuticCategory, String> {
}
