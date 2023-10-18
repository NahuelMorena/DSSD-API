package com.example.dssdapi.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.repositories.ProviderReserveMaterialRepository;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;

@Service
public class ProviderReserveMatServiceImplementation implements ProviderReserveMaterialService {
	
	@Autowired
	private ProviderReserveMaterialRepository providerReserveMatRepository;

	@Transactional
	public ProviderReserveMaterial createProviderReserveMaterial(Provider provider,Material material,Integer quantity,LocalDate deliveryDate) {
		ProviderReserveMaterial pr=new ProviderReserveMaterial(provider,material,quantity,deliveryDate);
		pr=providerReserveMatRepository.save(pr);
		return pr;
	}

	@Transactional
	public List<ProviderReserveMaterial> getAllReserves() {
		return (List<ProviderReserveMaterial>) this.providerReserveMatRepository.findAll();
	}

}
