package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableMBeanExport;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "Account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId", length = 50)
    private int accountId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;

//    Account join Gender
    @ManyToOne
    @JoinColumn(name = "genderId")
    private GenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private RoleEntity role;

    //join cart
    @OneToMany(mappedBy = "account")
    private Set<CartEntity> carts;

    // Join create React
    @ManyToMany
    @JoinTable(name = "React",
            joinColumns = @JoinColumn(name = "accountId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<ProductEntity> products;
}
