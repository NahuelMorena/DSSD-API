package com.example.dssdapi.services;

import java.time.LocalDate;
import java.util.List;

import com.example.dssdapi.Utils.RandomDecisionUtils;
import com.example.dssdapi.model.*;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dssdapi.repositories.DateSpaceRepository;
import com.example.dssdapi.services.interfaces.DateSpaceService;

@Service
public class DateSpaceServiceImplementation implements DateSpaceService {
	
	@Autowired
	private DateSpaceRepository dateSpaceRepository;

	@Transactional
	public List<DateSpaces> getAvailableSpaces() {
		return this.dateSpaceRepository.findAvailableSpaces();
	}

	@Transactional
	public List<DateSpaces> getAvailableSpacesByDates(LocalDate from, LocalDate until) {
		return this.dateSpaceRepository.findAvailableSpacesByDates(from, until);
	}

	@Transactional
	public List<DateSpaces> getReservedSpaces() { return this.dateSpaceRepository.findReservedSpaces(); }

	@Transactional
	public DateSpaces updateReservedSpace(DateSpaces ds) {
		ds.setReserved(true);
		ds=this.dateSpaceRepository.save(ds);
		return ds;
	}

	@Transactional
	public DateSpaces createDateSpaces(ManufacturingSpace manufacturingSpace, LocalDate available_from, LocalDate available_until) {
		DateSpaces ds = new DateSpaces(manufacturingSpace, available_from, available_until, false);
		ds = this.dateSpaceRepository.save(ds);
		return ds;
	}


	@Transactional
	public DateSpaces getById(Long id) {
		return this.dateSpaceRepository.findById(id).orElse(null);
	}

	@Transactional
	public Boolean manufacturingCompletionInquiry(ProviderReserveMaterial reserve) {
		//DateSpaces dateSpaces = this.getById(reserve.getDateSpaces().getId());
		//Operación sobre dateSpaces que pueda determinar si termino el proceso de fabricación

		//Función que devuelve un valor booleano aleatorio
		return RandomDecisionUtils.makeRandomDecision();
	}
}
