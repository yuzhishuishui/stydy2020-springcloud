package lsl.study2020.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHystrixController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/get")
    public String getSuccess(){
        return "This is a success service!\t"+Thread.currentThread().getName()+"\tport:"+serverPort;
    }

    @GetMapping("/payment/hystrix/out")
    public String getTimeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Service timeout!\t"+Thread.currentThread().getName()+"\tport:"+serverPort;
    }
}
