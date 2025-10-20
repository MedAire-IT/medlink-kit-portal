package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TherapeuticCategories")
@Immutable
public class TherapeuticCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private int categoryId;

    @Column(name = "SystemId", insertable = false, updatable = false)
    private int systemId;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "CategoryDescription")
    private String categoryDescription;

    @Column(name = "VisibleCategory")
    private boolean visibleCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SystemId")
    private TherapeuticSystem therapeuticSystem;

    @OneToMany(mappedBy = "therapeuticCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TherapeuticSystemAssignment> therapeuticSystemAssignments = new HashSet<>();

    // Constructors
    public TherapeuticCategory() {
        this.therapeuticSystemAssignments = new HashSet<>();
    }
}

