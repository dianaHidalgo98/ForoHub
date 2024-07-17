package com.alura.forohub.controller;

import com.alura.forohub.domain.usuarios.DataUserAuthentication;
import com.alura.forohub.domain.usuarios.User;
import com.alura.forohub.infra.security.DataJWTToken;
import com.alura.forohub.infra.security.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Authentication", description = "Gets the token for the assigned user that gives access to the rest of the endpoint.")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authUser(@RequestBody @Valid DataUserAuthentication dataUserAuthentication) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(dataUserAuthentication.login(),
                dataUserAuthentication.clave());
        var userAuthenticate = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((User) userAuthenticate.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(JWTtoken));
    }

}