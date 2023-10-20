package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "manufacturing_spaces")
public class ManufacturingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturingSpace")
    private Set<DateSpaces> dateSpacesSet;

    private String name;
    private String direction;
    private Float price_per_day;
    private String phone;
    private String email;

    public ManufacturingSpace(){}
    
    

	public ManufacturingSpace(Set<DateSpaces> dateSpacesSet, String name, String direction, Float price_per_day,
			String phone, String email) {
		this.dateSpacesSet = dateSpacesSet;
		this.name = name;
		this.direction = direction;
		this.price_per_day = price_per_day;
		this.phone = phone;
		this.email = email;
	}



	public Long getId() {
		return id;
	}

	public Set<DateSpaces> getDateSpacesSet() {
		return dateSpacesSet;
	}

	public String getName() {
		return name;
	}

	public String getDirection() {
		return direction;
	}

	public Float getPrice_per_day() {
		return price_per_day;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
    
    
}
