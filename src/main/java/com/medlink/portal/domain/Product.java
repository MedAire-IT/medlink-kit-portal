package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Products")
@Immutable
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "GenericName")
    private String genericName;

    @Column(name = "BrandName")
    private String brandName;

    @Column(name = "ProductTypeId")
    private int productTypeId;

    @Column(name = "ProductItemNumber")
    private String productItemNumber;

    @Column(name = "ProductSource")
    private String productSource;

    @Column(name = "ProductAlert")
    private String productAlert;

    @Column(name = "ControlledDrug")
    private boolean controlledDrug;

    @Column(name = "Concentration")
    private String concentration;

    @Column(name = "SizeOrStrength")
    private String sizeOrStrength;

    @Column(name = "FormOrType")
    private String formOrType;

    @Column(name = "UnitVolume")
    private String unitVolume;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "QuantityVolume")
    private String quantityVolume;

    @Column(name = "ItemQty")
    private int itemQty;

    @Column(name = "AltItemQty")
    private String altItemQty;

    @Column(name = "DateModified")
    private LocalDateTime dateModified;

    @Column(name = "DateAdded", nullable = false)
    private LocalDateTime dateAdded;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KitPackProduct> kitPackProducts = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<KitProduct> kitProducts = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductMedicalNote> productMedicalNotes = new HashSet<>();

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductTag productTag;

    // Constructors
    public Product() {
        this.kitPackProducts = new HashSet<>();
        this.kitProducts = new HashSet<>();
        this.productMedicalNotes = new HashSet<>();
    }
}

