package com.guilherme.paymentservice.service;

import com.guilherme.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}

