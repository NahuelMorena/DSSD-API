package com.example.dssdapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dssdapi.model.Provider;

public interface ProviderRepository extends CrudRepository<Provider,Long> {

}
