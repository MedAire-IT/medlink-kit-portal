package com.medlink.portal.repository;

import com.medlink.portal.domain.KitBuildWithClassification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitBuildWithClassificationRepository extends JpaRepository<KitBuildWithClassification, Integer> {
    List<KitBuildWithClassification> findByKitIdAndTherapeuticClassIdAndTherapeuticSubClassId(int kitId, int therapeuticClassId, int therapeuticSubClassId);

    List<KitBuildWithClassification> findByKitIdAndTherapeuticClassId(int kitId, int therapeuticClassId);
}
