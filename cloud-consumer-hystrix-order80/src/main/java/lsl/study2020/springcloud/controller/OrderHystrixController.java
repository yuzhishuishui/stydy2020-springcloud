package lsl.study2020.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lsl.study2020.springcloud.service.OrderHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;


    @GetMapping("/consumer/payment/hystrix/get")@HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHelper",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String getSuccess(){
        return orderHystrixService.getSuccess();
    }

    @GetMapping("/consumer/payment/hystrix/out")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHelper",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String getTimeout(){
        return orderHystrixService.getTimeout();
    }

    public String paymentInfo_TimeoutHelper(){
        return "controller breaker...";
    }
}
