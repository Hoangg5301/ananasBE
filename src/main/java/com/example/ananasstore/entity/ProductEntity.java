package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "promotion_id")
    private PromotionEntity promotion;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "collection_id")
    private CollectionEntity collection;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_type_id")
    private ProductTypeEntity productType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductDetailEntity> productDetails;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<AccountEntity> accounts;
}
