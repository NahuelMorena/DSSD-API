package com.example.dssdapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.dssdapi.model.DateSpaces;
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
	
	@GetMapping(baseUrl + "/getAvailableSpaces")
    @Operation(summary = "Obtener espacios disponibles", description = "Obtiene el listado de todos los espacios que se encuentran disponbiles aún")
    @ApiResponse(responseCode = "200", description = "Espacios encontrados", content = @Content(mediaType = "application/json"))
	public HttpEntity<List<DateSpaces>> getAvailableSpaces(){
		return ResponseEntity.ok(this.dateSpaceService.getAvailableSpaces());
	}
	
	@PutMapping(baseUrl + "/reserveManufacturingSpace/{id}")
	 @Operation(summary = "Reservar espacio de fabribación", description = "Reserva un espacio de fabricación indicando id")
    @ApiResponse(responseCode = "200", description = "Reserva realizada exitosamente", content = @Content(mediaType = "application/json"))
	public HttpEntity<DateSpaces> reserveSpace(@PathVariable Long id){
		DateSpaces ds=this.dateSpaceService.getById(id);
		if(ds!=null &&  ! ds.getReserved()) {
			ds=this.dateSpaceService.updateReservedSpace(ds);
			return ResponseEntity.ok(ds);
		}
		else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
}
