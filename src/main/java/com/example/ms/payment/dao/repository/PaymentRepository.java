package com.example.ms.payment.dao.repository;

import com.example.ms.payment.dao.entity.PaymentEntity;
import com.example.ms.payment.model.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findByIdAndStatus(Long id, PaymentStatus paymentStatus);

    Optional<PaymentEntity> findByOrderIdAndStatus(Long orderId, PaymentStatus paymentStatus);
}
