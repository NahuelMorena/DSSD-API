package com.example.dssdapi.services;

import java.time.LocalDate;
import java.util.List;

import com.example.dssdapi.model.*;
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
	
	
}
