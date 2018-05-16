/*
 * Copyright (c) 2018 - Hansard Global Plc
 */
package com.hansard.exaxe.policyservice;

import com.hansard.exaxe.adminplus.domain.Policy;
import com.hansard.exaxe.services.ServiceSecurity;
import org.tempuri.IPolicyWebService;
import org.tempuri.PolicyWebService;

/**
 * @author Richard Cowin
 */
public class JaxWsPolicyServiceClient {

    public static void main(String[] args) {

        PolicyWebService helloService = new PolicyWebService();
        IPolicyWebService hello = helloService.getBasicHttpBindingIPolicyWebService();

        ServiceSecurity security = new ServiceSecurity();
        security.setUserId("exHD-ap-sit01SB");
        security.setPassword("*****");
        security.setAuditId("xxx");
        security.setEncrypted(false);

        Policy policy = hello.getPolicy(security, "en", "12345");
        System.out.println(policy);
    }


}
