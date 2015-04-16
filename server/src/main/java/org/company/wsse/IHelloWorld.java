package org.company.wsse;

import org.apache.cxf.annotations.WSDLDocumentation;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://wsssampl.company.org/")
@WSDLDocumentation(value = "Тестовый сервис")
public interface IHelloWorld {
    @WebMethod()
    @WSDLDocumentation(value = "Получение версии сервиса")
    String getVersion();
}
