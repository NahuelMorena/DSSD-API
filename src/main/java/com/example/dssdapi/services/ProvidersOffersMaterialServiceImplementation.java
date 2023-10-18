package com.example.dssdapi.services;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.repositories.ProviderOffersMaterialRepository;
import com.example.dssdapi.services.interfaces.ProviderOffersMaterialService;

@Service
public class ProvidersOffersMaterialServiceImplementation implements ProviderOffersMaterialService {
	
	@Autowired
	private ProviderOffersMaterialRepository providerOffersMatRepository;

	@Override
	public List<ProviderOffersMaterial> getOffersByMaterialName(String materialName, Date dateStartManufacture) {
		return providerOffersMatRepository.findOffersByMaterialName(materialName,dateStartManufacture.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	@Override
	public ProviderOffersMaterial getById(Long id) {
		return this.providerOffersMatRepository.findById(id).orElse(null);
	}

	@Override
	public void updateQuantityProviderOffersMaterial(ProviderOffersMaterial po,Integer newQuantity) {
		po.setQuantity_available(newQuantity);
		this.providerOffersMatRepository.save(po);
	}
	
	
	
}
