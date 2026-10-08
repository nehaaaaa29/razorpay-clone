package com.razorpayproject.razorpay.merchant.dto.request;

import com.razorpayproject.razorpay.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
