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

	public Material( String name,Set<ProviderOffersMaterial> offers, Set<ProviderReserveMaterial> reserves) {
		this.name = name;
		this.offers = offers;
		this.reserves = reserves;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
    
    
}
