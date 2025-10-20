package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "vwYachtingKitBuild")
@Immutable // Hibernate-specific annotation for read-only views
public class VwYachtingKitBuild {

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
    private LocalDate productExpirationDate;

    @Column(name = "ProductTypeDescription")
    private String productTypeDescription;

    @Column(name = "ProductSerialNumber")
    private String productSerialNumber;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "TherapeuticSystemId")
    private Integer therapeuticSystemId;

    @Column(name = "TherapeuticSystem")
    private String therapeuticSystem;

    @Column(name = "TherapeuticClassId")
    private Integer therapeuticClassId;

    @Column(name = "TherapeuticSubClass")
    private String therapeuticSubClass;

    @Column(name = "UnitQuantity")
    private String unitQuantity;

    public VwYachtingKitBuild() {
        // Default constructor
    }
}
