package com.razorpayproject.razorpay.merchant.dto.response;

import com.razorpayproject.razorpay.common.enums.BusinessType;
import com.razorpayproject.razorpay.common.enums.MerchantStatus;
import com.razorpayproject.razorpay.merchant.entity.Merchant;

import java.util.UUID;

public record  MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus

        ) {
}
