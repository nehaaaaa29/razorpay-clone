package com.razorpayproject.razorpay.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "order_record")
public class OrderRecord {
    @Id
    private UUID id;
    private UUID merchantId;


}
