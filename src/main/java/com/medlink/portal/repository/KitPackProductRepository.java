package com.medlink.portal.repository;

import com.medlink.portal.domain.KitPackProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KitPackProductRepository extends JpaRepository<KitPackProduct, Integer> {
    List<KitPackProduct> findByKitIdAndSubPackIdAndProductId(int kitId, int subPackId, int productId);


}
