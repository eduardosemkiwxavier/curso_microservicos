package com.eduardosemkiwxavier.hrpayroll.services;

import com.eduardosemkiwxavier.hrpayroll.entities.Payment;
import com.eduardosemkiwxavier.hrpayroll.entities.Worker;
import com.eduardosemkiwxavier.hrpayroll.feignclients.WorkerFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long worker_id, int days){


        Worker worker = workerFeignClient.findById(worker_id).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
