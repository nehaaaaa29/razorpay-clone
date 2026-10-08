package com.razorpayproject.razorpay.merchant.service.impl;

import com.razorpayproject.razorpay.common.exception.ResourceNotFoundException;
import com.razorpayproject.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.razorpayproject.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.razorpayproject.razorpay.merchant.entity.ApiKey;
import com.razorpayproject.razorpay.merchant.entity.Merchant;
import com.razorpayproject.razorpay.merchant.repository.ApiKeyRepository;
import com.razorpayproject.razorpay.merchant.repository.MerchantRepository;
import com.razorpayproject.razorpay.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {
    private  final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;
    @Override
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(()->new ResourceNotFoundException("merchant",merchantId));
        String keyId="rzp_"+request.environment().name().toUpperCase()+"big_randon_String";
        String rawSecret="big_random_secret";//TODO: replace with repographic random hex

        ApiKey apiKey= ApiKey.builder()
                .merchant(merchant)
                .key_id(keyId)
                .key_secret_hash(rawSecret)//TODo:encode
                .environment(request.environment())
                .build();
        apiKey=apiKeyRepository.save(apiKey);
        return new ApiKeyCreateResponse(apiKey.getId(),keyId,rawSecret,request.environment());


    }
}
