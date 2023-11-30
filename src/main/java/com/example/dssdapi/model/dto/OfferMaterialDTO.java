package com.example.dssdapi.model.dto;

public class OfferMaterialDTO {
	private Long idProviderOfferMaterial;
	private Long collection_id;
	private Integer quantity;
	
	
	public Long getIdProviderOfferMaterial() {
		return idProviderOfferMaterial;
	}
	public void setIdProviderOfferMaterial(Long idProviderOfferMaterial) {
		this.idProviderOfferMaterial = idProviderOfferMaterial;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getCollection_id() {
		return collection_id;
	}

	public void setCollection_id(Long collection_id) {
		this.collection_id = collection_id;
	}
}
