package com.example.dssdapi.services.interfaces;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.dssdapi.model.ManufacturingSpace;
import com.example.dssdapi.model.ProviderReserveMaterial;
import org.springframework.stereotype.Service;

import com.example.dssdapi.model.DateSpaces;

@Service
public interface DateSpaceService {
	
	public List<DateSpaces> getAvailableSpaces();
	public List<DateSpaces> getReservedSpaces();
	public DateSpaces updateReservedSpace(DateSpaces ds);
	public DateSpaces createDateSpaces(ManufacturingSpace manufacturingSpace, LocalDate available_from, LocalDate available_until);
	public DateSpaces getById(Long id);
	public Boolean manufacturingCompletionInquiry(ProviderReserveMaterial reserve);
}
