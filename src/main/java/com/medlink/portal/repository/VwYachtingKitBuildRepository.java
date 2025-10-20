package com.medlink.portal.repository;

import com.medlink.portal.domain.SmartSheetKitBuild;
import com.medlink.portal.domain.VwYachtingKitBuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwYachtingKitBuildRepository extends JpaRepository<VwYachtingKitBuild, String> {

    List<VwYachtingKitBuild> findAllByKitId(int kitId);

}
