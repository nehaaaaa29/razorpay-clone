package com.razorpayproject.razorpay.merchant.entity;

import com.razorpayproject.razorpay.common.enums.Environment;
import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@Table(name = "api_key")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "merchant_id",nullable = false)
    private  Merchant merchant;

    @Column(nullable = false,length = 50,unique = true)
    private String key_id;

    @Column(nullable = false,length = 200)
    private String key_secret_hash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 10)
    private Environment environment;

    @Column(nullable = false)
    @Builder.Default
    private boolean enabled=true;

    private java.time.LocalDateTime lastUsedAt;
    private java.time.LocalDateTime RotatedAt;
    private java.time.LocalDateTime gracePeriodExpiresAt;



}
