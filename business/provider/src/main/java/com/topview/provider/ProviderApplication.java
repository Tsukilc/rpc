package com.topview.provider;

import dto.ServiceRegisterDto;
import infra.ServiceRegisterClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.spi.ServiceRegistry;

@SpringBootApplication
public class ProviderApplication {
    public static void main(String[] args) {
        rpcInit();
        SpringApplication.run(ProviderApplication.class, args);
    }

    public static void rpcInit(){
        ServiceRegisterClient serviceRegisterClient = new ServiceRegisterClient();
        serviceRegisterClient.register(new ServiceRegisterDto("provider", "127.0.0.1", "8080"));
    }

}
