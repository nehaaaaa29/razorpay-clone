package com.razorpayproject.razorpay.merchant.repository;

import com.razorpayproject.razorpay.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey,UUID>{
}
