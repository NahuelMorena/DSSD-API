package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="role_types")
public class RoleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role")
    private Set<Provider> providers;

    public RoleType(){}
}
