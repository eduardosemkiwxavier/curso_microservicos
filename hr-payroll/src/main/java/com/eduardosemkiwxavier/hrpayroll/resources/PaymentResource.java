package com.eduardosemkiwxavier.hrpayroll.resources;

import com.eduardosemkiwxavier.hrpayroll.entities.Payment;
import com.eduardosemkiwxavier.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @GetMapping(value = "/{worker_id}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long worker_id, @PathVariable Integer days){
        Payment payment = service.getPayment(worker_id, days);
        return ResponseEntity.ok(payment);
    }

}
