package com.example.ms.payment.exception;

public interface ExceptionConstants {
    String UNEXPECTED_EXCEPTION_CODE = "UNEXPECTED_EXCEPTION";
    String UNEXPECTED_EXCEPTION_MESSAGE = "Unexpected exception occurred";

    String PAYMENT_NOT_FOUND_CODE = "PAYMENT_NOT_FOUND";
    String PAYMENT_NOT_FOUND_BY_ID_MESSAGE = "PAYMENT with id: %s not found";

    String PAYMENT_NOT_FOUND_BY_ORDER_ID_MESSAGE = "PAYMENT with order id: %s not found";

    String CLIENT_ERROR_MESSAGE = "Exception from client";
    String EMPTY_MESSAGE_FROM_CLIENT_ERROR_MESSAGE = "Empty message from client ";

    String ORDER_NOT_FOUND_CODE = "ORDER_NOT_FOUND";
    String ORDER_NOT_FOUND_MESSAGE = "ORDER with id: %s not found";

    String ACCESS_DENIED_CODE = "ACCESS_DENIED";
    String ACCESS_DENIED_MESSAGE = "User doesn't have access for this operation!";


    String PRODUCT_ALREADY_REGISTERED_CODE = "PRODUCT_ALREADY_CREATED";
    String PRODUCT_ALREADY_REGISTERED_MESSAGE = "PRODUCT is already registered";
}
