/*
 * Copyright (c) 2018 - Hansard Global Plc
 */
package com.hansard.exaxe.policyservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ServiceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.hansard.exaxe.org.tempuri",
                "com.hansard.exaxe.adminplus.domain");
        return marshaller;
    }

    @Bean
    public SpringWsPolicyServiceClient policyServiceClient(Jaxb2Marshaller marshaller) {
        SpringWsPolicyServiceClient client = new SpringWsPolicyServiceClient();
        client.setDefaultUri("http://localhost/PolicyWebService/PolicyWebService.svc");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
