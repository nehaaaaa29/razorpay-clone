package com.razorpayproject.razorpay.merchant.repository;

import com.razorpayproject.razorpay.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {


}
