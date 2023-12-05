package com.example.dssdapi.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.dssdapi.model.DateSpaces;
import org.springframework.data.repository.query.Param;

public interface DateSpaceRepository extends CrudRepository<DateSpaces,Long> {

	@Query("SELECT d FROM DateSpaces d WHERE d.reserved=false")
	List<DateSpaces> findAvailableSpaces();

	@Query("SELECT d FROM DateSpaces d WHERE d.reserved=true")
	List<DateSpaces> findReservedSpaces();

	@Query("SELECT d FROM DateSpaces d WHERE d.reserved = false " +
		"AND (:from BETWEEN d.available_from AND d.available_until) " +
		"AND (:until BETWEEN d.available_from AND d.available_until)")
	List<DateSpaces> findAvailableSpacesByDates(@Param("from") LocalDate from, @Param("until")LocalDate until);
}
