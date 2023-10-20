package com.example.dssdapi.services.interfaces;

import org.springframework.stereotype.Service;
import com.example.dssdapi.model.Provider;

@Service
public interface ProviderService {
	public Provider getById(Long id);
}
