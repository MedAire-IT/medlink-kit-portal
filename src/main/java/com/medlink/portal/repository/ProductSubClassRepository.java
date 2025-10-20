package com.medlink.portal.repository;

import com.medlink.portal.domain.ProductSubClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSubClassRepository extends JpaRepository<ProductSubClass, Integer> {
}
