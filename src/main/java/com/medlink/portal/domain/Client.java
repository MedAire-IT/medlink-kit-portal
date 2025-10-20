package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "Clients")
@Entity
@Immutable
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClientId")
    private int clientId;

    @Column(name = "ClientName")
    private String clientName;

    @Column(name = "ClientIndustry")
    private String clientIndustry;

    @Column(name = "ClientTypeCode")
    private String clientTypeCode;

    @Column(name = "IATACode")
    private String iataCode;

    @Column(name = "CallSign")
    private String callSign;

    @Column(name = "SalesForceId")
    private Integer salesForceId;

    @Column(name = "ClientLogo")
    private String clientLogo;

    @Column(name = "ActiveClient")
    private boolean activeClient;

    @Column(name = "InternalOnly")
    private boolean internalOnly;

    @Column(name = "DateModified")
    private LocalDateTime dateModified;

    @Column(name = "DateAdded", nullable = false)
    private LocalDateTime dateAdded;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientKit> clientKits = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientDocument> clientDocuments = new HashSet<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientNotification> clientNotifications = new HashSet<>();

    // Constructors
    public Client() {
        this.clientKits = new HashSet<>();
        this.clientDocuments = new HashSet<>();
        this.clientNotifications = new HashSet<>();
    }

}
