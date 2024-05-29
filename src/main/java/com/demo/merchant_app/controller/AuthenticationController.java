package com.demo.merchant_app.controller;

import com.demo.merchant_app.dto.AuthenticationRequestDTO;
import com.demo.merchant_app.dto.AuthenticationResponseDTO;
import com.demo.merchant_app.dto.RegisterRequestDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) throws ApiException {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
