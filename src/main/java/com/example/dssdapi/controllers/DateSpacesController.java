package com.example.dssdapi.controllers;

import java.util.List;

import com.example.dssdapi.model.*;
import com.example.dssdapi.model.dto.DatesSpacesDTO;
import com.example.dssdapi.model.dto.ReserveidDTO;
import com.example.dssdapi.model.dto.ReservesDto;
import com.example.dssdapi.services.interfaces.ManufacturingSpaceService;
import com.example.dssdapi.services.interfaces.ProviderReserveMaterialService;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.dssdapi.services.interfaces.DateSpaceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Controller
@SecurityRequirement(name = "bearerAuth")
@Tags(value= {@Tag(name="Fechas espacios de fabricación",description="Endpoints de reserva de fechas espacios de fabricación")})
public class DateSpacesController {

	private final String baseUrl = "/api/dateSpaces";
	
	@Autowired
	private DateSpaceService dateSpaceService;

	@Autowired
	private ManufacturingSpaceService manufacturingSpaceService;

	@Autowired
	private ProviderReserveMaterialService providerReserveMaterialService;
	
	@GetMapping(baseUrl + "/getAvailableSpaces")
    @Operation(summary = "Obtener espacios disponibles", description = "Obtiene el listado de todos los espacios que se encuentran disponbiles aún")
    @ApiResponse(responseCode = "200", description = "Espacios encontrados", content = @Content(mediaType = "application/json"))
	public HttpEntity<List<DateSpaces>> getAvailableSpaces(){
		return ResponseEntity.ok(this.dateSpaceService.getAvailableSpaces());
	}

	@GetMapping(baseUrl + "/getReservedSpaces")
	@Operation(summary = "Obtener espacios reservados", description = "Obtiene el listado de todos los plazos de los espacios de fabricación que ya hayan sido reservados")
	@ApiResponse(responseCode= "200", description = "Plazos de espacios encontrados", content = @Content(mediaType = "application/json"))
	public HttpEntity<List<DateSpaces>> getReservedSpaces(){
		return ResponseEntity.ok(this.dateSpaceService.getReservedSpaces());
	}

	@PostMapping(baseUrl + "/createDateSpaces")
	@Operation(summary = "Crear un plazo", description = "Crea un nuevo plazo de uso para un espacio de fabricación indicando"
			+ "el id del espacio de fabricación a la cual pertenece y desde que fecha hasta cual fecha se lleva a cabo el plazo")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
		examples = @ExampleObject(value = "{\n" +
			    "  \"idManufacturingSpace\": 2,\n" +
			    "  \"available_from\": \"28-10-2023\",\n" +
			    "  \"available_until\": \"10-11-2023\"\n" +
			    "}")))
	public HttpEntity<DateSpaces> createDateSpaces(@RequestBody DatesSpacesDTO request){
		ManufacturingSpace m = this.manufacturingSpaceService.getById(request.getIdManufacturingSpace());
		if(m!=null){
			DateSpaces ds = this.dateSpaceService.createDateSpaces(m, request.getAvailable_from(), request.getAvailable_until());
			return ResponseEntity.ok(ds);
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PutMapping(baseUrl + "/reserveManufacturingSpace/{id}")
	 @Operation(summary = "Reservar espacio de fabribación", description = "Reserva un espacio de fabricación indicando id")
    @ApiResponse(responseCode = "200", description = "Reserva realizada exitosamente", content = @Content(mediaType = "application/json"))
	public HttpEntity<DateSpaces> reserveSpace(@PathVariable Long id, @RequestBody ReservesDto request){
		DateSpaces ds=this.dateSpaceService.getById(id);
		if(ds!=null &&  ! ds.getReserved()) {
			for (ReservesDto.ReserveRequest reserve : request.getReserves()){
				ProviderReserveMaterial prm = providerReserveMaterialService.getByID(reserve.getId())
								.orElseThrow(() -> new RuntimeException("La reserva no se encontro"));
				providerReserveMaterialService.alocateManufacturingSpace(prm, ds);
			}
			return ResponseEntity.ok(this.dateSpaceService.updateReservedSpace(ds));
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(baseUrl + "/checkAvailableManufacturingSpace")
	@Operation(summary = "Consulta de espacio de fabricación disponible", description = "Se consulta sobre la posible disposición de periodos de tiempo de espacios de fabricación a reservar")
	@ApiResponse(responseCode = "200", description = "Consulta sobre posibles espacios de fabricación disponibles", content = @Content(mediaType = "application/json"))
	public HttpEntity<Boolean> checkAvailableManufacturingSpace(){
		return ResponseEntity.ok(! this.dateSpaceService.getAvailableSpaces().isEmpty());
	}

	@PostMapping(baseUrl + "/manufacturingCompletionInquiry")
	@Operation(summary = "Consulta sobre la finalización de la fabricación", description = "Se consulta sobre el posible finalización del proceso de fabricación")
	@ApiResponse(responseCode = "200", description = "Consulta sobre posible finalización del proceso de fabricación", content = @Content(mediaType = "application/json"))
	public HttpEntity<Boolean> manufacturingCompletionInquiry(@RequestBody ReserveidDTO request){
		ProviderReserveMaterial providerReserveMaterial = this.providerReserveMaterialService.getByID(request.getReserve_id())
				.orElseThrow(() -> new RuntimeException("La reserva no se encontro"));
		return ResponseEntity.ok(this.dateSpaceService.manufacturingCompletionInquiry(providerReserveMaterial));
	}
}
