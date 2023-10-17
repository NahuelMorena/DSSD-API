package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "date_spaces")
public class DateSpaces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_manufacturingSpace")
    private ManufacturingSpace manufacturingSpace;

    private LocalDate available_from;

    private LocalDate available_until;

    private Boolean reserved;

    public DateSpaces() {}
}
