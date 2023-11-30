package com.example.dssdapi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.dssdapi.Utils.RandomDecisionUtils;
import com.example.dssdapi.model.DateSpaces;
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
	public ProviderReserveMaterial createProviderReserveMaterial(Provider provider,Material material,Integer quantity,LocalDate deliveryDate, Long collection_id) {
		ProviderReserveMaterial pr=new ProviderReserveMaterial(provider,material,quantity,deliveryDate,collection_id);
		pr=providerReserveMatRepository.save(pr);
		return pr;
	}

	@Transactional
	public List<ProviderReserveMaterial> getAllReserves() {
		return (List<ProviderReserveMaterial>) this.providerReserveMatRepository.findAll();
	}

	@Transactional
	public Optional<ProviderReserveMaterial> getByID(Long id) {
		return this.providerReserveMatRepository.findById(id);
	}

	@Transactional
	public void alocateManufacturingSpace(ProviderReserveMaterial reserve, DateSpaces dateSpaces) {
		reserve.setDateSpaces(dateSpaces);
		this.providerReserveMatRepository.save(reserve);
	}

	@Transactional
	public List<ProviderReserveMaterial> getByCollectionId(Long collection_id) {
		return this.providerReserveMatRepository.findByCollectionId(collection_id);
	}

	@Transactional
	public Boolean queryExistanceOfDelays(List<Long> reserves_ids){
		/*
		for (Long reserveId : reserves_ids) {
			ProviderReserveMaterial reserve = this.getByID(reserveId)
					.orElseThrow(() -> new RuntimeException("La reserva no se encontro"));
			//Operación sobre la reserva que pueda determinar si existe una demora
		}
		*/

		//Funcion que devuelve un valor booleano aleatorio
		return RandomDecisionUtils.makeRandomDecision();
	}

	@Transactional
	public Boolean checkArrivalOfAllMaterials(List<Long> reserves_ids) {
		/*
		for (Long reserveId : reserves_ids) {
			ProviderReserveMaterial reserve = this.getByID(reserveId)
					.orElseThrow(() -> new RuntimeException("La reserva no se encontro"));
			//Operación sobre la reserva que pueda determinar si existe una demora
		}
		*/


		//Funcion que devuelve un valor booleano aleatorio
		return RandomDecisionUtils.makeRandomDecision();
	}

}
