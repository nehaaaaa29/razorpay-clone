package com.razorpayproject.razorpay.operations.entity;

import com.razorpayproject.razorpay.common.enums.WebhookEventStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="webhook_event")
public class WebhookEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID merchantId;

    private String evenType;

    private Map<String,Object> payload;

    private String targetUrl;

    private String signature;

    private WebhookEventStatus status;

    private Integer attempts;

    private LocalDateTime  nextRetryAt;

    private LocalDateTime lastAttemptAT;

    private Integer lastResponseCode;



}
