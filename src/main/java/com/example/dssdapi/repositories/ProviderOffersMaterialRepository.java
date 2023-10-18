package com.example.dssdapi.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.ProviderOffersMaterial;

public interface ProviderOffersMaterialRepository extends CrudRepository<ProviderOffersMaterial,Long> {
	 @Query("SELECT p FROM ProviderOffersMaterial p WHERE p.material.name = :materialName and p.delivery_date_available <= :dateStartManufacture")
	    List<ProviderOffersMaterial> findOffersByMaterialName(String materialName,LocalDate dateStartManufacture);
}
