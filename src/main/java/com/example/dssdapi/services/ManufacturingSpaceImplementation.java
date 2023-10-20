package com.example.dssdapi.services;

import com.example.dssdapi.model.ManufacturingSpace;
import com.example.dssdapi.repositories.ManufacturingSpaceRepository;
import com.example.dssdapi.services.interfaces.ManufacturingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ManufacturingSpaceImplementation implements ManufacturingSpaceService {
    @Autowired
    private ManufacturingSpaceRepository manufacturingSpaceRepository;
    @Transactional
    public ManufacturingSpace getById(Long id) {
        return this.manufacturingSpaceRepository.findById(id).orElse(null);
    }

}
