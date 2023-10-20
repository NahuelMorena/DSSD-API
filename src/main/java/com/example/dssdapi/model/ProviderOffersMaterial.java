package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate delivery_date_available;

    private Float price_by_unit;

    public ProviderOffersMaterial(){}

	public ProviderOffersMaterial(Provider provider, Material material, Integer quantity_available,
			LocalDate delivery_date_available, Float price_by_unit) {
		super();
		this.provider = provider;
		this.material = material;
		this.quantity_available = quantity_available;
		this.delivery_date_available = delivery_date_available;
		this.price_by_unit = price_by_unit;
	}

	public Integer getQuantity_available() {
		return quantity_available;
	}

	public void setQuantity_available(Integer quantity_available) {
		this.quantity_available = quantity_available;
	}

	public Long getId() {
		return id;
	}

	public Provider getProvider() {
		return provider;
	}

	public Material getMaterial() {
		return material;
	}

	public LocalDate getDelivery_date_available() {
		return delivery_date_available;
	}

	public Float getPrice_by_unit() {
		return price_by_unit;
	}
    
    
    
}
