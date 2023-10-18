package com.example.dssdapi.services.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dssdapi.model.ProviderOffersMaterial;

@Service
public interface ProviderOffersMaterialService {
	public List<ProviderOffersMaterial> getOffersByMaterialName(String materialName,Date dateStartManufacture);
	public ProviderOffersMaterial getById(Long id);
	public void updateQuantityProviderOffersMaterial(ProviderOffersMaterial po,Integer newQuantity);
	public List<ProviderOffersMaterial> getAllOffers();
	
}
