package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "vw_Clients")
@Immutable // Hibernate-specific annotation to mark this entity as read-only
public class VwClients {

    @Id
    @Column(name = "ClientId")
    private int clientId;

    @Column(name = "ClientName")
    private String clientName;

    @Column(name = "ClientIndustry")
    private String clientIndustry;

    public VwClients() {
        // Default constructor
    }
}

