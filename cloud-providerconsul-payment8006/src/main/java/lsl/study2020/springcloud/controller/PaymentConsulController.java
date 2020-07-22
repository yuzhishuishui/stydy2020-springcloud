package lsl.study2020.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String servePort;

    @GetMapping("payment/consul")
    public String consul(){
        return "This server is on the Consul.\tport"+servePort+"\t"+ UUID.randomUUID().toString();
    }
}
