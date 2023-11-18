package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dateSpaces")
	private DateSpaces dateSpaces;

    private Integer quantity;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate delivery_date;

    private Integer number_of_rescheduling;

    public ProviderReserveMaterial(){}

	public ProviderReserveMaterial(Provider provider, Material material, Integer quantity, LocalDate delivery_date) {
		this.provider = provider;
		this.material = material;
		this.quantity = quantity;
		this.delivery_date = delivery_date;
		this.number_of_rescheduling=0;
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

	public Integer getQuantity() {
		return quantity;
	}

	public LocalDate getDelivery_date() {
		return delivery_date;
	}

	public Integer getNumber_of_rescheduling() {
		return number_of_rescheduling;
	}

	public DateSpaces getDateSpaces() { return dateSpaces; }

	public void setDateSpaces(DateSpaces dateSpaces) {
		this.dateSpaces = dateSpaces;
	}
}