package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "TherapeuticSystems")
@Immutable
public class TherapeuticSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SystemId")
    private int systemId;

    @Column(name = "SystemName", nullable = false)
    private String systemName;

    @Column(name = "SystemDescription")
    private String systemDescription;

    @Column(name = "Priority")
    private boolean priority;

    @OneToMany(mappedBy = "therapeuticSystem", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TherapeuticCategory> therapeuticCategories = new HashSet<>();

    public TherapeuticSystem() {
        // Safe constructor initialization
    }

}

