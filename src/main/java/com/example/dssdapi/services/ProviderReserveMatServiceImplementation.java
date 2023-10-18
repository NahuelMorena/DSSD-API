package com.example.dssdapi.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.repositories.ProviderReserveMaterialRepository;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;

@Service
public class ProviderReserveMatServiceImplementation implements ProviderReserveMaterialService {
	
	@Autowired
	private ProviderReserveMaterialRepository providerReserveMatRepository;

	@Override
	public ProviderReserveMaterial createProviderReserveMaterial(Provider provider,Material material,Integer quantity,LocalDate deliveryDate) {
		
		return null;
	}

}
