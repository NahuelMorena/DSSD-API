package com.example.dssdapi.controllers;

import java.util.List;

import com.example.dssdapi.model.dto.QueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dssdapi.model.ProviderOffersMaterial;
import com.example.dssdapi.model.ProviderReserveMaterial;
import com.example.dssdapi.model.dto.OfferMaterialDTO;
import com.example.dssdapi.services.interfaces.ProviderOffersMaterialService;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Controller
@SecurityRequirement(name = "bearerAuth")
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
		if(providerOffer!= null && providerOffer.getQuantity_available() >= request.getQuantity() && request.getQuantity() > 0) {
			ProviderReserveMaterial providerReserveMaterial=this.providerReserveMatService.createProviderReserveMaterial(providerOffer.getProvider(), 
					providerOffer.getMaterial(),request.getQuantity(),providerOffer.getDelivery_date_available(),request.getCollection_id());
			this.providerOffersMatService.updateQuantityProviderOffersMaterial(providerOffer,providerOffer.getQuantity_available()-request.getQuantity());
			return ResponseEntity.ok(providerReserveMaterial); 
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping(baseUrl + "/getAllReserve")
    @Operation(summary = "Obtener reservas de materiales", description = "Obtiene el listado de todas las reservas de materiales")
    @ApiResponse(responseCode = "200", description = "Reservas encontradas", content = @Content(mediaType = "application/json"))
    public HttpEntity<List<ProviderReserveMaterial>> getFurnitures(){
        return ResponseEntity.ok(this.providerReserveMatService.getAllReserves());
    }

	@GetMapping(baseUrl + "/getByCollectionId/{collection_id}")
	@Operation(summary = "Obtener reservas filtradas por id collection", description = "Obtiene el listado de todas las reservas filtradas por el id de la colección")
	@ApiResponse(responseCode = "200", description = "Reservas encontradas por id de la colección", content = @Content(mediaType = "application/json"))
	public HttpEntity<List<ProviderReserveMaterial>> getByIdCollection(@PathVariable Long collection_id){
		return ResponseEntity.ok(this.providerReserveMatService.getByCollectionId(collection_id));
	}

	@PostMapping(baseUrl + "/queryExistanceOfDelays")
	@Operation(summary = "Consulta existencia de retrasos", description = "Consulta la existencia de posibles retrasos en la entrega de materiales")
	@ApiResponse(responseCode = "200", description = "Se respondio sobre la existencia de retrasos", content = @Content(mediaType = "application/json"))
	public HttpEntity<Boolean> queryExistanceOfDelays(@RequestBody QueryDTO request){
		return ResponseEntity.ok(this.providerReserveMatService.queryExistanceOfDelays(request.getIds()));
	}

	@PostMapping(baseUrl + "/checkArrivalOfAllMaterials")
	@Operation(summary = "Consulta de llegada de todos los materiales", description = "Consulta de si llegaron todos los materiales necesarios al espacio de fabricación")
	@ApiResponse(responseCode = "200", description = "Se respondio sobre si se produjo la llegada de todos los materiales", content = @Content(mediaType = "application/json"))
	public HttpEntity<Boolean> checkArrivalOfAllMaterials(@RequestBody QueryDTO request){
		return ResponseEntity.ok(this.providerReserveMatService.checkArrivalOfAllMaterials(request.getIds()));
	}

}
