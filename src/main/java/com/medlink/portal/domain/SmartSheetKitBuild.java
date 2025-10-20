package com.medlink.portal.domain;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "SmartSheetKitBuild")
@Immutable
public class SmartSheetKitBuild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KitId")
    private int kitId;

    @Column(name = "KitItemNumber")
    private String kitItemNumber;

    @Column(name = "PackId")
    private String packId;

    @Column(name = "PackDescription")
    private String packDescription;

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

    @Column(name = "QuantityOnHand")
    private String quantityOnHand;

    @Column(name = "ProductExpirationDate")
    private LocalDateTime productExpirationDate;

    @Column(name = "ProductSerialNumber")
    private String productSerialNumber;

    @Column(name = "ProductTypeId")
    private int productTypeId;

    @Column(name = "ProductTypeDescription")
    private String productTypeDescription;

    @Column(name = "SizeOrStrength")
    private String sizeOrStrength;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "TherapeuticClassId")
    private Integer therapeuticClassId;

    @Column(name = "TherapeuticSubClassId")
    private Integer therapeuticSubClassId;

    @Column(name = "TherapeuticSubClass")
    private String therapeuticSubClass;

    @Column(name = "ControlledDrug")
    private boolean controlledDrug;
}

