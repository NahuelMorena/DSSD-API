package com.example.dssdapi.InitiliazeDb;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.model.RoleType;
import com.example.dssdapi.repositories.MaterialRepository;
import com.example.dssdapi.repositories.ProviderOffersMaterialRepository;
import com.example.dssdapi.repositories.ProviderRepository;

@Component
public class DbInitializer implements ApplicationRunner {
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired 
	private ProviderOffersMaterialRepository providerOffersMatRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Material material1=new Material("Madera", new HashSet<ProviderOffersMaterial>(),new HashSet<ProviderReserveMaterial>());
		this.materialRepository.save(material1);
		Provider provider1=new Provider(RoleType.PRODUCTOR,new HashSet<ProviderOffersMaterial>(),new HashSet<ProviderReserveMaterial>(),"Proveedor1","221-1111111", "Proveedor1@gmail.com");
		this.providerRepository.save(provider1);
		ProviderOffersMaterial po1=new ProviderOffersMaterial(provider1, material1, 10, LocalDate.of(2023, 11, 5),Float.valueOf(150));
		this.providerOffersMatRepository.save(po1);
		   Material material2 = new Material("Plástico", new HashSet<>(), new HashSet<>());
	        Material material3 = new Material("Vidrio", new HashSet<>(), new HashSet<>());
	        Material material4 = new Material("Papel", new HashSet<>(), new HashSet<>());

	        this.materialRepository.saveAll(List.of(material2, material3, material4));

	        Provider provider2 = new Provider(RoleType.RECICLADOR, new HashSet<>(), new HashSet<>(), "Proveedor2", "222-2222222", "Proveedor2@gmail.com");
	        this.providerRepository.save(provider2);

	        ProviderOffersMaterial po2 = new ProviderOffersMaterial(provider1, material2, 20, LocalDate.of(2023, 11, 10), Float.valueOf(100));
	        ProviderOffersMaterial po3 = new ProviderOffersMaterial(provider1, material3, 15, LocalDate.of(2023, 11, 7), Float.valueOf(90));
	        ProviderOffersMaterial po4 = new ProviderOffersMaterial(provider2, material4, 30, LocalDate.of(2023, 11, 15), Float.valueOf(80));

	        this.providerOffersMatRepository.saveAll(List.of(po2, po3, po4));
	}
	
	
}
