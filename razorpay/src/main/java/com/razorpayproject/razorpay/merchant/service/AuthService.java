package com.razorpayproject.razorpay.merchant.service;

import com.razorpayproject.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.razorpayproject.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    MerchantResponse signup(MerchantSignupRequest request);
}
