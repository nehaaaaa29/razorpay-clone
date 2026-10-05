package com.razorpayproject.razorpay.operations.entity;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class SettlementPaymentId {
    private UUID settlement;


    private UUID paymentId;
}
