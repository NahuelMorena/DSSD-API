package com.example.dssdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.DateSpaces;

public interface DateSpaceRepository extends CrudRepository<DateSpaces,Long> {

	@Query("SELECT d FROM DateSpaces d WHERE d.reserved=false")
	List<DateSpaces> findAvailableSpaces();

	@Query("SELECT d FROM DateSpaces d WHERE d.reserved=true")
	List<DateSpaces> findReservedSpaces();
}
