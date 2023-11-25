package com.example.dssdapi.repositories;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.ProviderOffersMaterial;

public interface ProviderOffersMaterialRepository extends CrudRepository<ProviderOffersMaterial,Long> {
	 @Query("SELECT p FROM ProviderOffersMaterial p WHERE LOWER(p.material.name) = LOWER(:materialName) and p.delivery_date_available <= :dateStartManufacture and p.quantity_available != 0"
	 		+ " and p.delivery_date_available > CURRENT_DATE")
	    List<ProviderOffersMaterial> findOffersByMaterialName(String materialName,LocalDate dateStartManufacture);
}
