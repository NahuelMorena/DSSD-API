package com.example.dssdapi.services.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dssdapi.model.Material;

@Service
public interface MaterialService {
	public List<Material> getAllMaterials();
}
