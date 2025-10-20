package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "KitTypes")
@Immutable
public class KitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KitTypeId")
    private int kitTypeId;

    @Column(name = "KitTypeCode")
    private String kitTypeCode;

    @Column(name = "KitTypeDescription")
    private String kitTypeDescription;

    @OneToMany(mappedBy = "kitType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ClientKit> clientKits = new HashSet<>();

    // Constructors
    public KitType() {
        this.clientKits = new HashSet<>();
    }
}

