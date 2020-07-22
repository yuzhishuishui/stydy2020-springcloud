package lsl.study2020.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private RestTemplate restTemplate;

    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/order/consul")
    public String consul(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

    @GetMapping("/get/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String server :
                services) {
            log.info("\nservices:"+server);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        ServiceInstance serviceInstance = instances.get(0);
        return serviceInstance;
    }
}
