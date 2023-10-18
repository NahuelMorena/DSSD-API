package com.example.dssdapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.repositories.MaterialRepository;
import com.example.dssdapi.services.interfaces.MaterialService;

@Service
public class MaterialServiceImplementation implements MaterialService {
	
	@Autowired
	private MaterialRepository  materialRepository;
	
	@Transactional
	public List<Material> getAllMaterials(){
		return (List<Material>)materialRepository.findAll();
	}
}
