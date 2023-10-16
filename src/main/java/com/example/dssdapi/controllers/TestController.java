package com.example.dssdapi.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@Controller
@Tags(value= {@Tag(name="Test",description="Test endpoints")})
public class TestController {

	@GetMapping("/api/prueba")
	 @Operation(summary = "Test endpoint", description = "Test endpoint")
    @ApiResponse(responseCode = "200", description = "Test works", content = @Content(mediaType = "application/json"))
    public HttpEntity<String> prueba(){
       return ResponseEntity.ok("Esta funcionando la api");
    }
}
