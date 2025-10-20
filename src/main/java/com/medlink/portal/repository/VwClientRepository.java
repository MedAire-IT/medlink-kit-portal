package com.medlink.portal.repository;

import com.medlink.portal.domain.VwClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwClientRepository extends JpaRepository<VwClients, Integer> {
    List<VwClients> findByClientIndustry(String clientIndustry);

}