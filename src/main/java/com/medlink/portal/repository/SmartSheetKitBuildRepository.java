package com.medlink.portal.repository;

import com.medlink.portal.domain.SmartSheetKitBuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartSheetKitBuildRepository extends JpaRepository<SmartSheetKitBuild, String> {

    List<SmartSheetKitBuild> findByKitId(Integer kitId);

}
