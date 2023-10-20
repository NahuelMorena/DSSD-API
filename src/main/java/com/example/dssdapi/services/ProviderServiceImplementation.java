package com.example.dssdapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dssdapi.model.Provider;
import com.example.dssdapi.repositories.ProviderRepository;
import com.example.dssdapi.services.interfaces.ProviderService;

@Service
public class ProviderServiceImplementation implements ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	@Transactional
	public Provider getById(Long id) {
		return this.providerRepository.findById(id).orElse(null);
	}

}
