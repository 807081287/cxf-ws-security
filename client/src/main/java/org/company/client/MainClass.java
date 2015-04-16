package org.company.client;

import org.apache.cxf.ws.security.SecurityConstants;
import org.company.client.handler.KeystorePasswordCallback;
import org.company.wsse.service.Hw;
import org.company.wsse.service.IHelloWorld;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import java.net.MalformedURLException;
import java.net.URL;

public class MainClass {
    public static void main(String[] args) throws MalformedURLException {
        QName serviceName = new QName("http://wsssampl.company.org/", "hw");
        URL url = new URL("http://localhost:8080/server/hw?wsdl");

        Hw hw = new Hw(url, serviceName);
        IHelloWorld servicePort = hw.getHwPort();

        BindingProvider bp = (BindingProvider) servicePort;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/server/hw");
        bp.getRequestContext().put(SecurityConstants.CALLBACK_HANDLER, new KeystorePasswordCallback());
        bp.getRequestContext().put(SecurityConstants.SIGNATURE_PROPERTIES, Thread.currentThread().getContextClassLoader().getResource("client.properties"));
        bp.getRequestContext().put(SecurityConstants.ENCRYPT_PROPERTIES, Thread.currentThread().getContextClassLoader().getResource("client.properties"));
        bp.getRequestContext().put(SecurityConstants.SIGNATURE_USERNAME, "myclientkey");
        bp.getRequestContext().put(SecurityConstants.ENCRYPT_USERNAME, "myservicekey");

        String version = servicePort.getVersion();

        System.out.println("-----------------------");
        System.out.println(version);
        System.out.println("-----------------------");
    }
}
