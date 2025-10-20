package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vwSmartSheetKitBuild")
@Immutable // Hibernate-specific annotation for read-only views
public class VwSmartSheetKitBuild {

    @Id
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "KitId")
    private int kitId;

    @Column(name = "PackId")
    private Integer packId;

    @Column(name = "PackDescription")
    private String packDescription;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "GenericName")
    private String genericName;

    @Column(name = "BrandName")
    private String brandName;

    @Column(name = "SizeOrStrength")
    private String sizeOrStrength;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "ItemQty")
    private int itemQty;

    @Column(name = "ProductClassId")
    private Integer productClassId;

    @Column(name = "ClassDescription")
    private String classDescription;

    @Column(name = "QuantityOnHand")
    private double quantityOnHand;

    @Column(name = "ProductType")
    private String productType;

    @Column(name = "ProductSource")
    private String productSource;

    @Column(name = "DateAdded")
    private LocalDateTime dateAdded;

    @Column(name = "ProductAlert")
    private String productAlert;

    @Column(name = "AltItemQty")
    private String altItemQty;

    @Column(name = "Alert")
    private String alert;

    public VwSmartSheetKitBuild() {
        // Default constructor
    }
}

