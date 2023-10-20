package com.example.dssdapi.services.interfaces;

import com.example.dssdapi.model.ManufacturingSpace;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturingSpaceService {
    public ManufacturingSpace getById(Long id);
}
