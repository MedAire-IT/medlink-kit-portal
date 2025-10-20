package com.medlink.portal.repository;

import com.medlink.portal.domain.KitPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitPackRepository extends JpaRepository<KitPack, String> {

}
