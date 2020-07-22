package lsl.study2020.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {

    @Resource
    private RestTemplate restTemplate;

    private static final String CONSUMER_URL = "http://cloud-provider-payment";

//    @Resource
//    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/get/zk")
    public String paymentZK(){
//        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
//        ServiceInstance instance = instances.get(0);
//        return restTemplate.getForObject(instance.getUri().toString()+"/consumer/get/zk",String.class);
        return restTemplate.getForObject(CONSUMER_URL+"/payment/getZK",String.class);
    }
}
