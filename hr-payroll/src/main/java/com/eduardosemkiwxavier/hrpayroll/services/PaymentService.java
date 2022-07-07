package com.eduardosemkiwxavier.hrpayroll.services;

import com.eduardosemkiwxavier.hrpayroll.entities.Payment;
import com.eduardosemkiwxavier.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long worker_id, int days){
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", ""+worker_id);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
