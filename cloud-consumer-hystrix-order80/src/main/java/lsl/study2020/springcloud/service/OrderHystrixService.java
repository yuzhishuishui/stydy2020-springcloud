package lsl.study2020.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = OrderFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/get")
    String getSuccess();

    @GetMapping("/payment/hystrix/out")
    String getTimeout();
}
