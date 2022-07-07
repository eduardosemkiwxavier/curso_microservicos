package com.eduardosemkiwxavier.hrpayroll.services;

import com.eduardosemkiwxavier.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long worker_id, int days){
        return new Payment("Bob", 200.0, days);
    }

}
