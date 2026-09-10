package com.razorpayproject.razorpay.payment.entity;

import com.razorpayproject.razorpay.common.entity.Money;
import com.razorpayproject.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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



}
