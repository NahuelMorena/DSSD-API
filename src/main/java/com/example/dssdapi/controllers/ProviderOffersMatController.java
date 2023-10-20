package com.example.dssdapi.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dssdapi.model.Material;
import com.example.dssdapi.model.Provider;
import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.model.dto.OfferMaterialPostDTO;
import com.example.dssdapi.services.interfaces.MaterialService;
import com.example.dssdapi.services.interfaces.ProviderOffersMaterialService;
import com.example.dssdapi.services.interfaces.ProviderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import io.swagger.v3.oas.annotations.media.ExampleObject;


@Controller
@SecurityRequirement(name = "bearerAuth")
@Tags(value= {@Tag(name="Ofertas de proveedores",description="Endpoints de ofertas de proveedores")})
public class ProviderOffersMatController {
	
	private final String baseUrl = "/api/offersMaterial";
	
	@Autowired
	private ProviderOffersMaterialService providerOffersMatService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private ProviderService providerService;
	
	@GetMapping(baseUrl)
	@Operation(summary = "Obtener ofertas usando filtro", description = "Obtener ofertas por nombre y fecha")
    @ApiResponse(responseCode = "200", description = "Ofertas encontradas", content = @Content(mediaType = "application/json"))
    public HttpEntity<List<ProviderOffersMaterial>> getOffersByMaterial(
    		@RequestParam(name = "materialName",required=true) String materialName,
    	    @RequestParam(name = "dateStartManufacture", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateStartManufacture){
       return ResponseEntity.ok(this.providerOffersMatService.getOffersByMaterialName(materialName,dateStartManufacture));
    }
	
	@GetMapping(baseUrl + "/getAllOffers")
    @Operation(summary = "Obtener todas las ofertas", description = "Obtiene el listado de todas las ofertas")
    @ApiResponse(responseCode = "200", description = "Ofertas encontradas", content = @Content(mediaType = "application/json"))
    public HttpEntity<List<ProviderOffersMaterial>> getFurnitures(){
        return ResponseEntity.ok(this.providerOffersMatService.getAllOffers());
    }
	
	@PostMapping(baseUrl + "/createOffer")
	@Operation(summary = "Crear ofertas", description = "Crea una oferta indicando id de proveedor,id de material,"
			+ "cantidad disponible, fecha de entrega disponible,precio por unidad")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
    examples = @ExampleObject(value = "{\n" +
    	    "  \"idProvider\": 2,\n" +
    	    "  \"idMaterial\": 1,\n" +
    	    "  \"quantity_available\": 15,\n" +
    	    "  \"delivery_date_available\": \"28-10-2023\",\n" +
    	    "  \"price_by_unit\": 100\n" +
    	    "}")))
	public HttpEntity<ProviderOffersMaterial> createOffer(@RequestBody OfferMaterialPostDTO request){
		Provider p=this.providerService.getById(request.getIdProvider());
		Material m=this.materialService.getById(request.getIdMaterial());
		if(p!=null && m!=null) {
			ProviderOffersMaterial po=this.providerOffersMatService.createOffer(p,m, request.getQuantity_available(), request.getDelivery_date_available(),request.getPrice_by_unit());
			return ResponseEntity.ok(po);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	
	
}
