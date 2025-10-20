package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KitPackProducts")
@Immutable
public class KitPackProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PackProductId")
    private int packProductId;

    @Column(name = "KitId")
    private int kitId;

    @Column(name = "PackId")
    private String packId;

    @Column(name = "ProductId", insertable = false, updatable = false)
    private int productId;

    @Column(name = "QuantityOnHand")
    private double quantityOnHand;

    @Column(name = "ProductExpirationDate")
    private LocalDateTime productExpirationDate;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "ProductSerialNumber")
    private String productSerialNumber;

    @Column(name = "DateAdded")
    private LocalDateTime dateAdded;

    @Column(name = "SubPackId")
    private int subPackId;

    @Column(name = "ProductSource")
    private String productSource;

    @Column(name = "Alert")
    private String alert;

    @Column(name = "AltItemQty")
    private String altItemQty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Product product;
}

