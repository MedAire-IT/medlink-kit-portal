package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KitBuildWithClassification")
@Immutable
public class KitBuildWithClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KitId")
    private int kitId;

    @Column(name = "KitItemNumber")
    private String kitItemNumber;

    @Column(name = "PackId")
    private int packId;

    @Column(name = "PackDescription")
    private String packDescription;

    @Column(name = "ProductItemNumber")
    private String productItemNumber;

    @Column(name = "ProductId")
    private int productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "GenericName")
    private String genericName;

    @Column(name = "BrandName")
    private String brandName;

    @Column(name = "QuantityOnHand")
    private double quantityOnHand;

    @Column(name = "ProductExpirationDate")
    private LocalDateTime productExpirationDate;

    @Column(name = "ProductSerialNumber")
    private String productSerialNumber;

    @Column(name = "ProductTypeId")
    private int productTypeId;

    @Column(name = "ProductClassId")
    private Integer productClassId;

    @Column(name = "TherapeuticClass")
    private String therapeuticClass;

    @Column(name = "ProductSubClassId")
    private Integer productSubClassId;

    @Column(name = "TherapeuticSubClass")
    private String therapeuticSubClass;

    @Column(name = "TypeDescription")
    private String typeDescription;

    @Column(name = "SizeOrStrength")
    private String sizeOrStrength;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "ControlledDrug")
    private boolean controlledDrug;

    @Column(name = "TherapeuticClassId")
    private Integer therapeuticClassId;

    @Column(name = "TherapeuticSubClassId")
    private Integer therapeuticSubClassId;

    @Column(name = "SubPackId")
    private int subPackId;

    @Column(name = "SubPackDescription")
    private String subPackDescription;

}

