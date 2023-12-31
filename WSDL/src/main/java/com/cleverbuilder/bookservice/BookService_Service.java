package com.cleverbuilder.bookservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-07-27T20:56:53.421+02:00
 * Generated source version: 4.0.2
 *
 */
@WebServiceClient(name = "BookService",
                  wsdlLocation = "file:/C:/Users/AdamPC/Documents/Programont/programont/WSDL/src/main/resources/book.wsdl",
                  targetNamespace = "http://www.cleverbuilder.com/BookService/")
public class BookService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.cleverbuilder.com/BookService/", "BookService");
    public final static QName BookServiceSOAP = new QName("http://www.cleverbuilder.com/BookService/", "BookServiceSOAP");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/AdamPC/Documents/Programont/programont/WSDL/src/main/resources/book.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BookService_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/AdamPC/Documents/Programont/programont/WSDL/src/main/resources/book.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BookService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BookService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BookService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BookService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BookService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BookService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns BookService
     */
    @WebEndpoint(name = "BookServiceSOAP")
    public BookService getBookServiceSOAP() {
        return super.getPort(BookServiceSOAP, BookService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BookService
     */
    @WebEndpoint(name = "BookServiceSOAP")
    public BookService getBookServiceSOAP(WebServiceFeature... features) {
        return super.getPort(BookServiceSOAP, BookService.class, features);
    }

}
