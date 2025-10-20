package com.medlink.portal.repository;

import com.medlink.portal.domain.VwKitBuild;
import com.medlink.portal.dto.KitContentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwKitBuildRepository extends JpaRepository<VwKitBuild, Integer> {
    List<VwKitBuild> findByKitIdAndTherapeuticSystemId(int kitId, int therapeuticSystemId);

    @Query(
            """
                        SELECT new com.medlink.portal.dto.KitMedViewHeader(
                            s.kitId,
                            s.productId,
                            s.genericName,
                            s.concentration,
                            s.brandName,
                            s.formOrType,
                            s.unitDose,
                            s.unitVolume,
                            COALESCE(s.therapeuticSystemId, 0),
                            COALESCE(s.therapeuticClassId, 0),
                            s.therapeuticSystem,
                            s.therapeuticCategory,
                            s.tags
                        )
                        FROM VwKitBuildHeader s
                        JOIN TherapeuticSystem system ON s.therapeuticSystemId = system.systemId
                        WHERE s.kitId = :kitId AND system.priority = true
                    """
    )
    List<KitContentsModel> findKitPriorityContents(@Param("kitId") int kitId);
}

