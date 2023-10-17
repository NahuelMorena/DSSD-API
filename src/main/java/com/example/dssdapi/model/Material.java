package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "material")
    private Set<ProviderOffersMaterial> offers;

    @OneToMany(mappedBy = "material")
    private Set<ProviderReserveMaterial> reserves;

    private String name;

    public Material(){}
}
