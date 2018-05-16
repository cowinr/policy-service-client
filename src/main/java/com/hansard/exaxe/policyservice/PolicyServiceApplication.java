package com.hansard.exaxe.policyservice;

import com.hansard.exaxe.adminplus.domain.Policy;
import com.hansard.exaxe.org.tempuri.GetPolicyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.bind.JAXBElement;

@SpringBootApplication
public class PolicyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolicyServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SpringWsPolicyServiceClient holidayServiceClient) {
        return args -> {
            String policyNumber = "12345";

            if (args.length > 0) {
                policyNumber = args[0];
            }

            GetPolicyResponse policyResponse = holidayServiceClient.getPolicy(policyNumber);
            JAXBElement<Policy> policyResult = policyResponse.getGetPolicyResult();
            System.err.println(policyResult);
        };
    }

}
