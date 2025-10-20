package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KitPacks")
@Immutable
public class KitPack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KitPackId")
    private int kitPackId;

    @Column(name = "ClientId", insertable = false, updatable = false)
    private int clientId;

    @Column(name = "KitId", insertable = false, updatable = false)
    private int kitId;

    @Column(name = "PackId")
    private int packId;

    @Column(name = "PackDescription")
    private String packDescription;

    @Column(name = "Source")
    private String source;

    @Column(name = "DateAdded")
    private LocalDateTime dateAdded;

    @Column(name = "SubPackId")
    private Integer subPackId;

    @Column(name = "SubPackDescription")
    private String subPackDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "ClientId", referencedColumnName = "ClientId"),
            @JoinColumn(name = "KitId", referencedColumnName = "KitId")
    })
    private ClientKit clientKit;

}
