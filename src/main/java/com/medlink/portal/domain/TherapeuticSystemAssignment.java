package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "TherapeuticSystemAssignments")
@Immutable
public class TherapeuticSystemAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "SystemId", nullable = false)
    private int systemId;

    @Column(name = "CategoryId", nullable = false)
    private int categoryId;

    @Column(name = "Visible")
    private boolean visible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "SystemId", referencedColumnName = "SystemId", insertable = false, updatable = false),
            @JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId", insertable = false, updatable = false)
    })
    private TherapeuticCategory therapeuticCategory;

    public TherapeuticSystemAssignment() {
        // Default constructor
    }
}
