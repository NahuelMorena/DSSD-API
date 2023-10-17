package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="providers_reserve_materials")
public class ProviderReserveMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material")
    private Material material;

    private Integer quantity;

    private LocalDate delivery_date;

    private Integer number_of_rescheduling;

    public ProviderReserveMaterial(){}
}