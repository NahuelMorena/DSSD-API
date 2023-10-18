package com.example.dssdapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.model.dto.OfferMaterialDTO;
import com.example.dssdapi.services.interfaces.ProviderOffersMaterialService;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Controller
@Tags(value= {@Tag(name="Reserva de materiales",description="Endpoints de reserva de materiales")})
public class ProviderReserveMatController {
	
	private final String baseUrl = "/api/reserveMaterials";
	
	@Autowired
	private ProviderReserveMaterialService providerReserveMatService;
	
	@Autowired
	private ProviderOffersMaterialService providerOffersMatService;
	
	@PostMapping(baseUrl+"/reserve/")
	@Operation(summary = "Reservar materiales", description = "Reserva un material indicando el id de la oferta y cantidad")
	public HttpEntity<ProviderReserveMaterial> reserveMaterial(@RequestBody OfferMaterialDTO request){
		ProviderOffersMaterial providerOffer=this.providerOffersMatService.getById(request.getIdProviderOfferMaterial());
		if(providerOffer!= null && providerOffer.getQuantity_available() >= request.getQuantity()) {
			ProviderReserveMaterial providerReserveMaterial=this.providerReserveMatService.createProviderReserveMaterial(providerOffer.getProvider(), 
					providerOffer.getMaterial(),request.getQuantity(),providerOffer.getDelivery_date_available());
			this.providerOffersMatService.updateQuantityProviderOffersMaterial(providerOffer,providerOffer.getQuantity_available()-request.getQuantity());
			return ResponseEntity.ok(providerReserveMaterial); 
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}
}
