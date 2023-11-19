package com.example.dssdapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "date_spaces")
public class DateSpaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_manufacturingSpace")
    private ManufacturingSpace manufacturingSpace;

	@JsonIgnore
	@OneToMany(mappedBy = "dateSpaces")
	private Set<ProviderReserveMaterial> reserves;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate available_from;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate available_until;

    private Boolean reserved;

    public DateSpaces() {}

	public DateSpaces(ManufacturingSpace manufacturingSpace, LocalDate available_from, LocalDate available_until,
			Boolean reserved) {
		this.manufacturingSpace = manufacturingSpace;
		this.available_from = available_from;
		this.available_until = available_until;
		this.reserved = reserved;
	}

	public Boolean getReserved() {
		return reserved;
	}

	public void setReserved(Boolean reserved) {
		this.reserved = reserved;
	}

	public Long getId() {
		return id;
	}

	public ManufacturingSpace getManufacturingSpace() {
		return manufacturingSpace;
	}

	public LocalDate getAvailable_from() {
		return available_from;
	}

	public LocalDate getAvailable_until() {
		return available_until;
	}
	
	
    
    
}
