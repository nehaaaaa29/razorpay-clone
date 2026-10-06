package com.razorpayproject.razorpay.merchant.service.impl;

import com.razorpayproject.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.razorpayproject.razorpay.merchant.dto.response.MerchantResponse;
import com.razorpayproject.razorpay.merchant.repository.AppUserRepository;
import com.razorpayproject.razorpay.merchant.repository.MerchantRepository;
import com.razorpayproject.razorpay.merchant.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    @Override
    public MerchantResponse signup(MerchantSignupRequest request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw  new RuntimeException("Merchant with email already exists:"+request.email());
        }

        return null;
    }
}
