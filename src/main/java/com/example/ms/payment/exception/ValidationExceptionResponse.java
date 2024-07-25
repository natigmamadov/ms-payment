package com.example.ms.payment.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationExceptionResponse {
    private String code;
    private String message;

    public ValidationExceptionResponse(String message) {
        this.message = message;
    }
}
