package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "vwKitBuildHeader")
@Immutable // Hibernate-specific annotation for read-only views
public class VwKitBuildHeader {

    @Id
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "KitId")
    private int kitId;

//    @Column(name = "SubPackId")
//    private int subPackId;

//    @Column(name = "SubPackDescription")
//    private String subPackDescription;

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

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "UnitQuantity")
    private String unitQuantity;

    @Column(name = "UnitDimension")
    private String unitDimension;

    @Column(name = "TherapeuticSystemId")
    private Integer therapeuticSystemId;

    @Column(name = "TherapeuticSystem")
    private String therapeuticSystem;

    @Column(name = "TherapeuticClassId")
    private Integer therapeuticClassId;

    @Column(name = "TherapeuticCategory")
    private String therapeuticCategory;

    @Column(name = "Tags")
    private String tags;

    public VwKitBuildHeader() {
        // Default constructor
    }
}

