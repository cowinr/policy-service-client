
/*
 * Copyright (c) 2018 - Hansard Global Plc
 */
package com.hansard.exaxe.policyservice;

import com.hansard.exaxe.org.tempuri.GetPolicy;
import com.hansard.exaxe.org.tempuri.GetPolicyResponse;
import com.hansard.exaxe.services.ServiceSecurity;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SpringWsPolicyServiceClient extends WebServiceGatewaySupport {

    private static final String SERVICE_URI = "http://localhost/PolicyWebService/PolicyWebService.svc";

    private static final String GET_POLICY_ACTION = "http://tempuri.org/IPolicyWebService/GetPolicy";

    public GetPolicyResponse getPolicy(String policyNumber) {
        GetPolicy request = new GetPolicy();
        request.setLangCode("en");
        request.setPolicyNumber(policyNumber);

        ServiceSecurity security = new ServiceSecurity();
        security.setUserId("exHD-ap-sit01SB");
        security.setPassword("*****");
        security.setAuditId("xxx");
        security.setEncrypted(false);

        request.setSecurityInfo(security);

        return (GetPolicyResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_URI,
                        request,
                        new SoapActionCallback(GET_POLICY_ACTION));
    }


}
