package lsl.study2020.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class PaymentHystrixMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8005.class,args);
    }
}
