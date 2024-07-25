package com.example.ms.payment.mapper;

import com.example.ms.payment.dao.entity.PaymentEntity;
import com.example.ms.payment.model.enums.PaymentStatus;
import com.example.ms.payment.model.request.CreatePaymentRequest;
import com.example.ms.payment.model.response.PaymentResponse;

import static com.example.ms.payment.model.enums.PaymentStatus.SUCCESS;

public enum PaymentMapper {
    PAYMENT_MAPPER;

    public PaymentEntity buildPaymentEntity(CreatePaymentRequest createPaymentRequest) {
        return PaymentEntity.builder()
                .orderId(createPaymentRequest.getOrderId())
                .price(createPaymentRequest.getPrice())
                .referenceNumber(createPaymentRequest.getReferenceNumber())
                .status(SUCCESS)
                .paymentType(createPaymentRequest.getPaymentType())
                .build();
    }

    public PaymentResponse buildPaymentResponse(PaymentEntity paymentEntity) {
        return PaymentResponse.builder()
                .id(paymentEntity.getId())
                .orderId(paymentEntity.getOrderId())
                .price(paymentEntity.getPrice())
                .referenceNumber(paymentEntity.getReferenceNumber())
                .status(paymentEntity.getStatus())
                .paymentType(paymentEntity.getPaymentType())
                .createdAt(paymentEntity.getCreatedAt())
                .build();
    }
}
