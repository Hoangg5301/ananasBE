package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Table(name = "Product")
@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private int productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "upper")
    private String upper;

    @Column(name = "outsole")
    private String outsole;

    @Column(name = "style")
    private String style;

    @Column(name = "informationDetail", columnDefinition = "TEXT")
    private String informationDetail;

    @ManyToOne
    @JoinColumn(name = "genderId")
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "promotionId")
    private PromotionEntity promotion;

    @ManyToOne
    @JoinColumn(name = "collectionId")
    private CollectionEntity collection;

    @ManyToOne
    @JoinColumn(name = "productTypeId")
    private ProductTypeEntity productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductDetailEntity> productDetails;
}
