package com.medlink.portal.repository;

import com.medlink.portal.domain.ProductClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductClassRepository extends JpaRepository<ProductClass, Integer> {
}
