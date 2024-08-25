package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "collection")
public class CollectionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private int collectionId;

    @Column(name = "collection_name")
    private String collectionName;

    @OneToMany(mappedBy = "collection")
    private Set<ProductEntity> products;
}
