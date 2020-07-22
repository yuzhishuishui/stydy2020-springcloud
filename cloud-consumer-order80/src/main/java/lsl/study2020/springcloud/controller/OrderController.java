package lsl.study2020.springcloud.controller;

import lsl.study2020.springcloud.entities.CommonResult;
import lsl.study2020.springcloud.entities.Payment;
import lsl.study2020.springcloud.lb.MyLB;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    MyLB myLB;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/save")
    public CommonResult save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/getlb")
    public String getLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance = myLB.getServiceInstance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForEntity(uri+"/payment/getlb",String.class).getBody();
    }
}
