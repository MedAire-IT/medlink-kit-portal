package com.medlink.portal.repository;

import com.medlink.portal.domain.ClientKit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
public interface ClientKitRepository extends JpaRepository<ClientKit, String> {

    Optional<ClientKit> findByClientId(Integer clientId);

    CompletableFuture<ClientKit> findAllByKitId(Integer kitId);
}
