package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KitProducts")
@Immutable
public class KitProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "ClientId", insertable = false, updatable = false)
    private int clientId;

    @Column(name = "KitId", insertable = false, updatable = false)
    private int kitId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ClientId", referencedColumnName = "ClientId"),
            @JoinColumn(name = "KitId", referencedColumnName = "KitId")
    })
    private ClientKit clientKit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", insertable = false, updatable = false)
    private Product product;
}

