package com.razorpayproject.razorpay.payment.entity;

import com.razorpayproject.razorpay.common.entity.Money;
import com.razorpayproject.razorpay.common.enums.PaymentMethod;
import com.razorpayproject.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    private UUID id;
  @ManyToOne
    private OrderRecord order;

    private UUID merchantId;

    private Money amount;

    private String idempotencyKey;

    private PaymentStatus status;

    private PaymentMethod method;

    private Map<String, Object> methodDetails;

    private String bankReference;

    private String errorCode;

    private String errorDescription;

    private LocalDateTime authorizedAt;

    private LocalDateTime capturedAt;

    private LocalDateTime refundedAt;

    private LocalDateTime failedAt;


}
