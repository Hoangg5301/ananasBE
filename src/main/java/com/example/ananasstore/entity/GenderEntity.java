package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "gender")
public class GenderEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id", length = 50)
    private int genderId;

    @Column(name = "gender_name")
    private String genderName;

    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<AccountEntity> accounts;

    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<ProductEntity> products;
}
