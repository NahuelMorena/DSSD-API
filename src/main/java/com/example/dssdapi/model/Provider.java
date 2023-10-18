package com.example.dssdapi.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "provider")
    private Set<ProviderOffersMaterial> offers;

    @OneToMany(mappedBy = "provider")
    private Set<ProviderReserveMaterial> reserves;

    private String name;

    private String phone;

    private String email;
    public Provider(){}
	public Provider(RoleType role, Set<ProviderOffersMaterial> offers, Set<ProviderReserveMaterial> reserves,
			String name, String phone, String email) {
		this.role = role;
		this.offers = offers;
		this.reserves = reserves;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public RoleType getRole() {
		return role;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	
	
    
    
}
