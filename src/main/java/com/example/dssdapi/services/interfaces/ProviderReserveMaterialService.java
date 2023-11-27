package com.example.dssdapi.services.interfaces;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.dssdapi.model.DateSpaces;
import org.springframework.stereotype.Service;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderReserveMaterial;

@Service
public interface ProviderReserveMaterialService {

	public ProviderReserveMaterial createProviderReserveMaterial(Provider provider,Material material,Integer quantity,LocalDate deliveryDate);
	public List<ProviderReserveMaterial> getAllReserves();
	public Optional<ProviderReserveMaterial> getByID(Long id);
	public void alocateManufacturingSpace(ProviderReserveMaterial reserve, DateSpaces dateSpaces);
	public Boolean queryExistanceOfDelays(List<Long> reserves_ids);
	public Boolean checkArrivalOfAllMaterials(List<Long> reserves_ids);
}
