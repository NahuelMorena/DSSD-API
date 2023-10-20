package com.example.dssdapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.services.interfaces.ProviderOffersMaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;


@Controller
@SecurityRequirement(name = "bearerAuth")
@Tags(value= {@Tag(name="Ofertas de proveedores",description="Endpoints de ofertas de proveedores")})
public class ProviderOffersMatController {
	
	private final String baseUrl = "/api/offersMaterial";
	
	@Autowired
	private ProviderOffersMaterialService providerOffersMatService;
	
	@GetMapping(baseUrl)
	@Operation(summary = "Obtener ofertas", description = "Obtener ofertas por nombre y fecha")
    @ApiResponse(responseCode = "200", description = "Works", content = @Content(mediaType = "application/json"))
    public HttpEntity<List<ProviderOffersMaterial>> getOffersByMaterial(
    		@RequestParam(name = "materialName",required=true) String materialName,
    	    @RequestParam(name = "dateStartManufacture", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateStartManufacture){
       return ResponseEntity.ok(this.providerOffersMatService.getOffersByMaterialName(materialName,dateStartManufacture));
    }
	
	@GetMapping(baseUrl + "/getAllOffers")
    @Operation(summary = "Obtener ofertas", description = "Obtiene el listado de todas las ofertas")
    @ApiResponse(responseCode = "200", description = "Ofertas encontradas", content = @Content(mediaType = "application/json"))
    public HttpEntity<List<ProviderOffersMaterial>> getFurnitures(){
        return ResponseEntity.ok(this.providerOffersMatService.getAllOffers());
    }

	
	
}
