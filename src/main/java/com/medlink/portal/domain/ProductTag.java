package com.medlink.portal.domain;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Table(name = "ProductTags")
@Immutable
public class ProductTag {

    @Id
    @Column(name = "ProductId")
    private int productId;

    @Column(name = "Tags")
    private String tags;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", insertable = false, updatable = false)
    private Product product;
}

