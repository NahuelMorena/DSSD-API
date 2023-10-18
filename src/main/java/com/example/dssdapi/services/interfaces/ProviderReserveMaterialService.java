package com.example.dssdapi.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderReserveMaterial;

@Service
public interface ProviderReserveMaterialService {

	public ProviderReserveMaterial createProviderReserveMaterial(Provider provider,Material material,Integer quantity,LocalDate deliveryDate);
	public List<ProviderReserveMaterial> getAllReserves();
}
