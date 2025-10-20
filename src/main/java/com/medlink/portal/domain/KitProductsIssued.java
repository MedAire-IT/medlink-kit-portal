package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KitProductsIssued")
@Immutable
public class KitProductsIssued {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "ClientId", insertable = false, updatable = false)
    private int clientId;

    @Column(name = "KitId", insertable = false, updatable = false)
    private int kitId;

    @Column(name = "PackId")
    private int packId;

    @Column(name = "CaseNumber")
    private String caseNumber;

    @Column(name = "QuantityIssued")
    private Double quantityIssued;

    @Column(name = "DateIssued")
    private LocalDateTime dateIssued;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ClientId", referencedColumnName = "ClientId"),
            @JoinColumn(name = "KitId", referencedColumnName = "KitId")
    })
    private ClientKit clientKit;
}

