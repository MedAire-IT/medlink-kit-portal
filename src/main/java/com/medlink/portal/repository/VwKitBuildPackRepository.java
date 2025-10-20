package com.medlink.portal.repository;

import com.medlink.portal.domain.VwKitBuildPack;
import com.medlink.portal.dto.KitContentsModel;
import com.medlink.portal.dto.KitPackItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwKitBuildPackRepository extends JpaRepository<VwKitBuildPack, String> {
    @Query("""
        SELECT new com.medlink.portal.dto.KitContentsModel(
        s.kitId,
        s.packId,
        TRIM(s.packDescription),
        s.subPackId,
        TRIM(s.subPackDescription),
        s.productId,
        TRIM(s.productName),
        TRIM(s.genericName),
        s.productExpirationDate,
        TRIM(s.concentration),
        TRIM(s.productSerialNumber),
        TRIM(s.brandName),
        TRIM(s.productTypeDescription),
        TRIM(s.formOrType),
        TRIM(s.unitDose),
        TRIM(s.unitVolume),
        s.unitQuantity
    )
    FROM VwKitBuildPack s
    WHERE s.packId = :packId
""")
    List<KitContentsModel> findByPackId(@Param("packId") String packId);


    @Query("""
    SELECT new com.medlink.portal.dto.KitContentsModel(
        s.kitId,
        s.packId,
        TRIM(s.packDescription),
        s.subPackId,
        TRIM(s.subPackDescription),
        s.productId,
        TRIM(s.productName),
        TRIM(s.genericName),
        s.productExpirationDate,
        TRIM(s.concentration),
        TRIM(s.productSerialNumber),
        TRIM(s.brandName),
        TRIM(s.productTypeDescription),
        TRIM(s.formOrType),
        TRIM(s.unitDose),
        TRIM(s.unitVolume),
        s.unitQuantity
    )
    FROM VwKitBuildPack s
    WHERE s.kitId = :kitId AND (s.productTypeId = 2 OR s.productTypeId = 4)
""")
    List<KitContentsModel> findByKitIdAndProductType(@Param("kitId") int kitId);



    @Query(
            """
                        SELECT new com.medlink.portal.dto.KitPackItem(
                            s.packDescription,
                            COALESCE(s.subPackDescription, ''),
                            s.productSerialNumber,
                            s.productExpirationDate,
                            s.quantityOnHand
                        )
                        FROM VwKitBuildPack s
                        WHERE s.kitId = :kitId AND s.productId = :productId
                        ORDER BY s.packDescription, s.subPackDescription
                    """
    )
    List<KitPackItem> findKitPackItems(@Param("kitId") int kitId, @Param("productId") int product);

}
