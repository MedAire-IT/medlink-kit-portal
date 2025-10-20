package com.medlink.portal.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ProductMedicalNotes")
@Immutable
public class ProductMedicalNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MedicalNoteId")
    private int medicalNoteId;

    @Column(name = "ProductId", insertable = false, updatable = false)
    private int productId;

    @Column(name = "MedicalNote")
    private String medicalNote;

    @Column(name = "ProductWarning")
    private String productWarning;

    @Column(name = "ManufacturerNote")
    private String manufacturerNote;

    @Column(name = "Active")
    private boolean active;

    @Column(name = "ProductRecall")
    private boolean productRecall;

    @Column(name = "ActiveDateStart")
    private LocalDateTime activeDateStart;

    @Column(name = "ActiveDateEnd")
    private LocalDateTime activeDateEnd;

    @Column(name = "NoteExpirationDate")
    private LocalDateTime noteExpirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId")
    private Product product;
}

