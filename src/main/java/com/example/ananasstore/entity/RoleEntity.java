package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Role")
public class RoleEntity {
    @Id
    @Column(name = "roleId")
    private int roleId;

    @Column(name = "roleName")
    private String roleName;

    @Column(name = "permissionList")
    private String permissionList;

    @OneToMany(mappedBy = "role")
    private Set<AccountEntity> accounts;
}
