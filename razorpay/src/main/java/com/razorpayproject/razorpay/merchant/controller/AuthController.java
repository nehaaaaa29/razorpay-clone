package com.razorpayproject.razorpay.merchant.controller;

import com.razorpayproject.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.razorpayproject.razorpay.merchant.dto.response.MerchantResponse;
import com.razorpayproject.razorpay.merchant.entity.Merchant;
import com.razorpayproject.razorpay.merchant.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping
    public ResponseEntity<MerchantResponse> signup(@RequestBody @Valid MerchantSignupRequest request){
       return ResponseEntity.status(HttpStatus.CREATED).body(
               authService.signup(request)
       )
    }




}
