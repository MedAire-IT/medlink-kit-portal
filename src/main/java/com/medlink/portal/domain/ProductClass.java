package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ProductClasses")
@Immutable
public class ProductClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductClassId")
    private int productClassId;

    @Column(name = "ClassDescription")
    private String classDescription;

    @Column(name = "MIMSClassification")
    private String mimsClassification;

    @Column(name = "ClassNotes")
    private String classNotes;

    @Column(name = "Active")
    private boolean active;

    @OneToMany(mappedBy = "productClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductSubClass> productSubClasses = new HashSet<>();

    // Constructors
    public ProductClass() {
        this.productSubClasses = new HashSet<>();
    }
}

