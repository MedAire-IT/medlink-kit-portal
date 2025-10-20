package com.medlink.portal.repository;

import com.medlink.portal.domain.TherapeuticSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TherapeuticSystemRepository extends JpaRepository<TherapeuticSystem, Integer> {
}
