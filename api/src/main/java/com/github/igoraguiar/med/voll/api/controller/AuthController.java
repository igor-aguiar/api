package com.github.igoraguiar.med.voll.api.controller;

import com.github.igoraguiar.med.voll.api.domain.User.DTO.UserDataLogin;
import com.github.igoraguiar.med.voll.api.domain.User.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid UserDataLogin data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
