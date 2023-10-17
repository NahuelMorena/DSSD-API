package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "manufacturing_spaces")
public class ManufacturingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "manufacturingSpace")
    private Set<DateSpaces> dateSpacesSet;

    private String name;
    private String direction;
    private Float price_per_day;
    private String phone;
    private String email;

    public ManufacturingSpace(){}
}
