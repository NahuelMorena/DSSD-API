package com.example.dssdapi.InitiliazeDb;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.dssdapi.model.DateSpaces;
import com.example.dssdapi.model.ManufacturingSpace;
import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.model.RoleType;
import com.example.dssdapi.model.User;
import com.example.dssdapi.model.UserRole;
import com.example.dssdapi.repositories.DateSpaceRepository;
import com.example.dssdapi.repositories.ManufacturingSpaceRepository;
import com.example.dssdapi.repositories.MaterialRepository;
import com.example.dssdapi.repositories.ProviderOffersMaterialRepository;
import com.example.dssdapi.repositories.ProviderRepository;
import com.example.dssdapi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DbInitializer implements ApplicationRunner {
	
	@Autowired
	UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private MaterialRepository materialRepository;
	
	@Autowired
	private ProviderRepository providerRepository;
	
	@Autowired 
	private ProviderOffersMaterialRepository providerOffersMatRepository;
	
	@Autowired
	private ManufacturingSpaceRepository manufacturingSpaceRepository;
	
	@Autowired
	private DateSpaceRepository dateSpacesRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if (materialRepository.count() == 0 && providerRepository.count() == 0 && providerOffersMatRepository.count() == 0) {
			if (userRepository.findByUsername("usuario").isEmpty()) {
				User user= User.builder()
					.username("usuario")
					.password(passwordEncoder.encode("1234"))
					.role(UserRole.USER)
					.build();
				userRepository.save(user);
			}
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
	        ManufacturingSpace manufacturingSpace1 = new ManufacturingSpace(
	                new HashSet<>(), 
	                "Espacio fabricación 1",
	                "Calle 0",
	                Float.valueOf(100),
	                "000-0000000",
	                "espacio1@example.com"
	            );
	            manufacturingSpaceRepository.save(manufacturingSpace1);

	            ManufacturingSpace manufacturingSpace2 = new ManufacturingSpace(
	                new HashSet<>(),  
	                "Espacio fabricación 2",
	                "Calle 1",
	                Float.valueOf(150), 
	                "111-1111111",
	                "espacio2@example.com"
	            );
	            manufacturingSpaceRepository.save(manufacturingSpace2);
	            
	      
	            DateSpaces dateSpaces1 = new DateSpaces(
	                manufacturingSpace1,
	                LocalDate.of(2023, 11, 5),
	                LocalDate.of(2023, 11, 10),
	                false 
	            );
	            dateSpacesRepository.save(dateSpaces1);

	            DateSpaces dateSpaces2 = new DateSpaces(
	                manufacturingSpace2,
	                LocalDate.of(2023, 11, 7),
	                LocalDate.of(2023, 11, 12),
	                false
	            );
	            dateSpacesRepository.save(dateSpaces2);
	            
	            DateSpaces dateSpaces3 = new DateSpaces(
	            	    manufacturingSpace1,
	            	    LocalDate.of(2023, 11, 15),
	            	    LocalDate.of(2023, 11, 20),
	            	    false
	            	);
	            	dateSpacesRepository.save(dateSpaces3);

	            	DateSpaces dateSpaces4 = new DateSpaces(
	            	    manufacturingSpace2,
	            	    LocalDate.of(2023, 11, 18),
	            	    LocalDate.of(2023, 11, 23),
	            	    false
	            	);
	            	dateSpacesRepository.save(dateSpaces4);

	            	DateSpaces dateSpaces5 = new DateSpaces(
	            	    manufacturingSpace1,
	            	    LocalDate.of(2023, 11, 25),
	            	    LocalDate.of(2023, 11, 30),
	            	    false
	            	);
	            	dateSpacesRepository.save(dateSpaces5);

	            	DateSpaces dateSpaces6 = new DateSpaces(
	            	    manufacturingSpace2,
	            	    LocalDate.of(2023, 11, 28),
	            	    LocalDate.of(2023, 12, 3),
	            	    false
	            	);
	            	dateSpacesRepository.save(dateSpaces6);
		 }
	}
	
	
}
