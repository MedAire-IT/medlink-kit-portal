package com.medlink.portal.repository;

import com.medlink.portal.domain.ClientNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientNotificationRepository extends JpaRepository<ClientNotification, Integer> {
    Optional<ClientNotification> findClientNotificationsByClientId(Integer clientId);
}
