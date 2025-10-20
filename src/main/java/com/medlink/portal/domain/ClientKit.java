package com.medlink.portal.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Immutable
@Table(name = "ClientKits")
public class ClientKit {

    @Id
    @Column(name = "ClientKitId")
    private String clientKitId;

    @Column(name = "ClientId", insertable = false, updatable = false)
    private int clientId;

    @Column(name = "KitId")
    private int kitId;

    @Column(name = "KitSource")
    private String kitSource;

    @Column(name = "KitTypeId", insertable = false, updatable = false)
    private int kitTypeId;

    @Column(name = "KitDescription")
    private String kitDescription;

    @Column(name = "KitAltDescription")
    private String kitAltDescription;

    @Column(name = "KitSerialNumber")
    private String kitSerialNumber;

    @Column(name = "VesselOrTailNumber")
    private String vesselOrTailNumber;

    @Column(name = "KitLocation")
    private String kitLocation;

    @Column(name = "KitPDF")
    private String kitPDF;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "DateUpdated")
    private LocalDateTime dateUpdated;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "KitNotes")
    private String kitNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientId")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KitTypeId")
    private KitType kitType;

    @OneToMany(mappedBy = "clientKit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KitProduct> kitProducts = new HashSet<>();

    @OneToMany(mappedBy = "clientKit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KitPack> kitPacks = new HashSet<>();

    @OneToMany(mappedBy = "clientKit", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KitProductsIssued> kitProductsIssueds = new HashSet<>();

    // Constructors
    public ClientKit() {
        this.kitProducts = new HashSet<>();
        this.kitPacks = new HashSet<>();
        this.kitProductsIssueds = new HashSet<>();
    }
}
