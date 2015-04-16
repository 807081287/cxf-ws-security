package org.company.wsse;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.ws.security.SecurityConstants;

import javax.jws.WebService;

//bp.getRequestContext().put(SecurityConstants.CALLBACK_HANDLER, new KeystorePasswordCallback());

@EndpointProperties(value = {
        @EndpointProperty(key = SecurityConstants.SIGNATURE_PROPERTIES, value = "server.properties"),
        @EndpointProperty(key = SecurityConstants.ENCRYPT_PROPERTIES, value = "server.properties"),
        @EndpointProperty(key = SecurityConstants.SIGNATURE_USERNAME, value = "myservicekey"),
        @EndpointProperty(key = SecurityConstants.ENCRYPT_USERNAME, value = "myclientkey"),
        @EndpointProperty(key = SecurityConstants.CALLBACK_HANDLER, value = "org.company.wsse.handler.KeystorePasswordCallback")
})
@WebService(portName = "hwPort",
        serviceName = "hw",
        wsdlLocation = "WEB-INF/wsdl/hw.wsdl",
        targetNamespace = "http://wsssampl.company.org/",
        endpointInterface = "org.company.wsse.IHelloWorld")
public class HelloWorldImpl implements IHelloWorld {

    @Override
    public String getVersion() {
        return "v 1.0";
    }
}
