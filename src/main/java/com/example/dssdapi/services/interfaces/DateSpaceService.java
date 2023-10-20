package com.example.dssdapi.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dssdapi.model.DateSpaces;

@Service
public interface DateSpaceService {
	
	public List<DateSpaces> getAvailableSpaces();
	public DateSpaces updateReservedSpace(DateSpaces ds);
	public DateSpaces getById(Long id);
}
