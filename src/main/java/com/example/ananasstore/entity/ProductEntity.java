package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Table(name = "product")
@Getter
@Setter
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "upper")
    private String upper;

    @Column(name = "outsole")
    private String outsole;

    @Column(name = "style")
    private String style;

    @Column(name = "information_detail", columnDefinition = "TEXT")
    private String informationDetail;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private PromotionEntity promotion;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private CollectionEntity collection;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductDetailEntity> productDetails;

    @ManyToMany(mappedBy = "products")
    private Set<AccountEntity> accounts;
}
