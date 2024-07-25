package com.example.ms.payment.model.request;

import com.example.ms.payment.model.constants.ApplicationConstants;
import com.example.ms.payment.model.enums.PaymentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static com.example.ms.payment.model.constants.ApplicationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {

    @NotNull(message = ORDER_ID_IS_REQUIRED)
    private Long orderId;

    @NotNull(message = PRICE_IS_REQUIRED)
    private BigDecimal price;

    @NotBlank(message = REFERENCE_NUMBER_IS_REQUIRED)
    private String referenceNumber;

    @NotNull(message = PAYMENT_TYPE_IS_REQUIRED)
    private PaymentType paymentType;
}
