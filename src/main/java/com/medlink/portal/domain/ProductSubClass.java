package com.medlink.portal.domain;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "ProductSubClasses")
@Immutable
public class ProductSubClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductSubClassId")
    private int productSubClassId;

    @Column(name = "ProductClassId", insertable = false, updatable = false)
    private int productClassId;

    @Column(name = "ClassDescription")
    private String classDescription;

    @Column(name = "MIMSClassification")
    private String mimsClassification;

    @Column(name = "Active")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductClassId")
    private ProductClass productClass;
}

