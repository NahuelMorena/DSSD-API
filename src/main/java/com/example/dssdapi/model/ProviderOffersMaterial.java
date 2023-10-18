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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Integer getQuantity_available() {
		return quantity_available;
	}

	public void setQuantity_available(Integer quantity_available) {
		this.quantity_available = quantity_available;
	}

	public LocalDate getDelivery_date_available() {
		return delivery_date_available;
	}

	public void setDelivery_date_available(LocalDate delivery_date_available) {
		this.delivery_date_available = delivery_date_available;
	}

	public Float getPrice_by_unit() {
		return price_by_unit;
	}

	public void setPrice_by_unit(Float price_by_unit) {
		this.price_by_unit = price_by_unit;
	}
    
    
}
