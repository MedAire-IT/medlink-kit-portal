package com.medlink.portal.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vwKitBuildPack")
@Immutable // Hibernate-specific annotation for read-only views
public class VwKitBuildPack {

    @Id
    @Column(name = "PackProductId")
    private int packProductId;

    @Column(name = "KitId")
    private int kitId;

    @Column(name = "PackId")
    private String packId;

    @Column(name = "PackDescription")
    private String packDescription;

    @Column(name = "SubPackId")
    private int subPackId;

    @Column(name = "SubPackDescription")
    private String subPackDescription;

    @Column(name = "Alert")
    private String alert;

    @Column(name = "ProductId")
    private int productId;

    @Column(name = "ProductItemNumber")
    private String productItemNumber;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "GenericName")
    private String genericName;

    @Column(name = "BrandName")
    private String brandName;

    @Column(name = "Concentration")
    private String concentration;

    @Column(name = "UnitDose")
    private String unitDose;

    @Column(name = "UnitVolume")
    private String unitVolume;

    @Column(name = "QuantityOnHand")
    private double quantityOnHand;

    @Column(name = "Quantity")
    private String quantity;

    @Column(name = "ProductExpirationDate")
    private LocalDateTime productExpirationDate;

    @Column(name = "ProductTypeDescription")
    private String productTypeDescription;

    @Column(name = "ProductSerialNumber")
    private String productSerialNumber;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "UnitQuantity")
    private String unitQuantity;

    @Column(name = "ProductTypeId")
    private int productTypeId;

    public VwKitBuildPack() {
        // Default constructor
    }
}

