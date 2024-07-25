package com.example.ms.payment.service.concrete;

import com.example.ms.payment.dao.entity.PaymentEntity;
import com.example.ms.payment.dao.repository.PaymentRepository;
import com.example.ms.payment.exception.NotFoundException;
import com.example.ms.payment.model.request.CreatePaymentRequest;
import com.example.ms.payment.model.response.PaymentResponse;
import com.example.ms.payment.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.example.ms.payment.exception.ExceptionConstants.*;
import static com.example.ms.payment.mapper.PaymentMapper.PAYMENT_MAPPER;
import static com.example.ms.payment.model.enums.PaymentStatus.DELETED;
import static com.example.ms.payment.model.enums.PaymentStatus.SUCCESS;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceHandler implements PaymentService {
    private final PaymentRepository paymentRepository;


    @Override
    public PaymentResponse pay(CreatePaymentRequest createPaymentRequest) {
        var paymentEntity = PAYMENT_MAPPER.buildPaymentEntity(createPaymentRequest);
        paymentRepository.save(paymentEntity);
        return PAYMENT_MAPPER.buildPaymentResponse(paymentEntity);
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        var paymentEntity = fetchPaymentIfExists(id);
        return PAYMENT_MAPPER.buildPaymentResponse(paymentEntity);
    }

    @Override
    public void deletePayment(Long id) {
        var paymentEntity = fetchPaymentIfExists(id);
        paymentEntity.setStatus(DELETED);
        paymentRepository.save(paymentEntity);
    }

    @Override
    public PaymentResponse getPaymentByOrderId(Long orderId) {
        return paymentRepository.findByOrderIdAndStatus(orderId, SUCCESS)
                .map(PAYMENT_MAPPER::buildPaymentResponse)
                .orElseThrow(() -> new NotFoundException(PAYMENT_NOT_FOUND_CODE,
                        String.format(PAYMENT_NOT_FOUND_BY_ORDER_ID_MESSAGE, orderId)));
    }

    private PaymentEntity fetchPaymentIfExists(Long id) {
        return paymentRepository.findByIdAndStatus(id, SUCCESS)
                .orElseThrow(() -> new NotFoundException(PAYMENT_NOT_FOUND_CODE,
                        String.format(PAYMENT_NOT_FOUND_BY_ID_MESSAGE, id)));
    }
}
