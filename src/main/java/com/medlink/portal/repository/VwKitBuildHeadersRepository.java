package com.medlink.portal.repository;

import com.medlink.portal.domain.VwKitBuildHeader;
import com.medlink.portal.dto.KitMedViewHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwKitBuildHeadersRepository extends JpaRepository<VwKitBuildHeader, String> {

    List<VwKitBuildHeader> findByKitId(int kitId);

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
    List<KitMedViewHeader> findKitPriorityContents(@Param("kitId") int kitId);

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
                        WHERE s.kitId = :kitId AND s.therapeuticSystemId = :systemId
                    """


    )
    List<KitMedViewHeader> findKitPriorityContentsAsync(@Param("kitId") int kitId, @Param("systemId") int systemId);


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
                        WHERE s.kitId = :kitId AND s.therapeuticSystemId = :systemId
                                             AND s.therapeuticClassId = :classId
                    """


    )
    List<KitMedViewHeader> findKitPriorityContentsAsync(@Param("kitId") int kitId, @Param("systemId") int systemId, @Param("classId") int classId);

}
