package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Collection")
public class CollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collectionId")
    private int collectionId;

    @Column(name = "collectionName")
    private String collectionName;

    @OneToMany(mappedBy = "collection")
    private Set<ProductEntity> products;
}
