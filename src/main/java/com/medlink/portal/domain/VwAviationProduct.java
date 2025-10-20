package com.medlink.portal.domain;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "vwAviationProducts")
@Immutable // Marks the entity as read-only (Hibernate-specific)
public class VwAviationProduct {

    @Id
    @Column(name = "ProductId")
    private int productId;

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

    @Column(name = "ProductTypeId")
    private Integer productTypeId; // Nullable in Java
    @Column(name = "TypeDescription")
    private String typeDescription;

    @Column(name = "ControlledDrug")
    private boolean controlledDrug;

    @Column(name = "ProductSource")
    private String productSource;

    @Column(name = "SourceProductId")
    private String sourceProductId;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    public VwAviationProduct() {
        // Default constructor
    }

}
