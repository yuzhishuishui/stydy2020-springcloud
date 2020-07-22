package lsl.study2020.springcloud.controller;

import lsl.study2020.springcloud.entities.CommonResult;
import lsl.study2020.springcloud.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping("/consumer/feign/get/{id}")
    public CommonResult getFeignPayment(@PathVariable("id")Long id){
        return orderFeignService.getPaymentById(id);
    }
}
