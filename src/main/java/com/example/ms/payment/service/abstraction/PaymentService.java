package com.example.ms.payment.service.abstraction;

import com.example.ms.payment.model.request.CreatePaymentRequest;
import com.example.ms.payment.model.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse pay(CreatePaymentRequest createPaymentRequest);

    PaymentResponse getPaymentById(Long id);

    void deletePayment(Long id);

    PaymentResponse getPaymentByOrderId(Long orderId);
}
