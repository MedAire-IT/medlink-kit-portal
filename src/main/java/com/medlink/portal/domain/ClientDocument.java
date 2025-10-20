package com.medlink.portal.domain;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.time.LocalDateTime;

@Data
@Entity
@Immutable
@Table(name = "ClientDocuments")
public class ClientDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentId")
    private int documentId;

    @Column(name = "ClientId", insertable = false, updatable = false)
    private int clientId;

    @Column(name = "DocumentName")
    private String documentName;

    @Column(name = "DocumentType")
    private String documentType;

    @Column(name = "FileName")
    private String fileName;

    @Column(name = "OrigFileName")
    private String origFileName;

    @Column(name = "OrigCreationDate")
    private LocalDateTime origCreationDate;

    @Column(name = "OrigModifiedDate")
    private LocalDateTime origModifiedDate;

    @Column(name = "DateUploaded")
    private LocalDateTime dateUploaded;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "UploadedBy")
    private String uploadedBy;

    @Column(name = "CreatedBy")
    private String createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClientId")
    private Client client;
}

