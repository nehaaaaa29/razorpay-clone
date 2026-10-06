package com.razorpayproject.razorpay.merchant.dto.request;

import com.razorpayproject.razorpay.common.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignupRequest(
   @NotNull (message = "Name is required")
   @Size(max=50,message ="Name should not be more than 50 character long" )
   String name,

   @Email
   @NotNull(message = "email is required")
   String email,

   @NotNull(message = "email is required")
   @Size(min =8,message = "password should be at least 8 characters")
   String password,

   @Size(max=50, message = "Business name should not be more than 50 characters long")
   String businessName,


   BusinessType businessType

)
{
}
