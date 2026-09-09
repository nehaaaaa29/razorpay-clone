package com.razorpayproject.razorpay.merchant.entity;

import com.razorpayproject.razorpay.common.enums.UserRole;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private Merchant merchantId;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Enumerated(EnumType.STRING
    )
    private UserRole role;


}
