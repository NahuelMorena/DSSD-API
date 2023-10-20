package com.example.dssdapi.configuration.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Tags(value= {@Tag(name="Autenticación",description="Endpoints de autenticación")})
public class AuthController {
    
    private final AuthService authService;
    
    @PostMapping(value = "login")
    @Operation(summary = "Iniciar sesión", description = "Inicia la sesión indicando usuario y contraseña.Retorna token JWT")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json",
    examples = @ExampleObject(value = "{\n" +
    	    "  \"username\": \"usuario\",\n" +
    	    "  \"password\": \"1234\"\n" +
    	    "}")))
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    @Operation(summary = "Registrar usuario", description = "Registra un usuario indicando usuario y contraseña")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }
}
