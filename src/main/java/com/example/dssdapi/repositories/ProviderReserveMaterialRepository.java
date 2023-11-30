package com.example.dssdapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.ProviderReserveMaterial;

import java.util.List;

public interface ProviderReserveMaterialRepository extends CrudRepository<ProviderReserveMaterial,Long> {
    List<ProviderReserveMaterial> findByCollectionId(Long collectionId);
}
