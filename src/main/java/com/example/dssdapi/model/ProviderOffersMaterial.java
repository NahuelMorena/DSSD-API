package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="providers_offers_materials")
public class ProviderOffersMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_provider")
    private Provider provider;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_material")
    private Material material;

    private Integer quantity_available;

    private LocalDate delivery_date_available;

    private Float price_by_unit;

    public ProviderOffersMaterial(){}
}
