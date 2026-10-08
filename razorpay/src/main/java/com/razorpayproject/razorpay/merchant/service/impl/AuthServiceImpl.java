package com.razorpayproject.razorpay.merchant.service.impl;

import com.razorpayproject.razorpay.common.enums.MerchantStatus;
import com.razorpayproject.razorpay.common.enums.UserRole;
import com.razorpayproject.razorpay.common.exception.DuplicateResourceException;
import com.razorpayproject.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.razorpayproject.razorpay.merchant.dto.response.MerchantResponse;
import com.razorpayproject.razorpay.merchant.entity.AppUser;
import com.razorpayproject.razorpay.merchant.entity.Merchant;
import com.razorpayproject.razorpay.merchant.repository.AppUserRepository;
import com.razorpayproject.razorpay.merchant.repository.MerchantRepository;
import com.razorpayproject.razorpay.merchant.service.AuthService;
import jakarta.transaction.Transactional;
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
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw  new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists:"+request.email());
        }
        Merchant merchant =Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();
        merchant= merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .password_hash(request.password())// todo:encrpt using bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);

        return new MerchantResponse(merchant.getId(),merchant.getEmail(),merchant.getName(),
                merchant.getBusinessName(),merchant.getBusinessType(),
                merchant.getStatus());
    }
}
