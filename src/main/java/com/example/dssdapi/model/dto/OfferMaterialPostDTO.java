package com.example.dssdapi.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OfferMaterialPostDTO {
	
	private Long idProvider;
	private Long idMaterial;
	private Integer quantity_available;
	@JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate delivery_date_available;

    private Float price_by_unit;

	public Long getIdProvider() {
		return idProvider;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public Integer getQuantity_available() {
		return quantity_available;
	}

	public LocalDate getDelivery_date_available() {
		return delivery_date_available;
	}

	public Float getPrice_by_unit() {
		return price_by_unit;
	}

	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public void setQuantity_available(Integer quantity_available) {
		this.quantity_available = quantity_available;
	}

	public void setDelivery_date_available(LocalDate delivery_date_available) {
		this.delivery_date_available = delivery_date_available;
	}

	public void setPrice_by_unit(Float price_by_unit) {
		this.price_by_unit = price_by_unit;
	}
    
    

}
