package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_role_type")
    private RoleType role;

    @OneToMany(mappedBy = "provider")
    private Set<ProviderOffersMaterial> offers;

    @OneToMany(mappedBy = "provider")
    private Set<ProviderReserveMaterial> reserves;

    private String name;

    private String phone;

    private String email;
    public Provider(){}
}
