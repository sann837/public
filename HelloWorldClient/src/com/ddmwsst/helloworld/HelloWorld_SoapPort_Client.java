
package com.ddmwsst.helloworld;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2012-01-22T20:15:57.353-07:00
 * Generated source version: 2.5.1
 * 
 */
public final class HelloWorld_SoapPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ddmwsst.com/helloworld", "HelloWorld");

    private HelloWorld_SoapPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = HelloWorld_Service.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        HelloWorld_Service ss = new HelloWorld_Service(wsdlURL, SERVICE_NAME);
        HelloWorld port = ss.getSoapPort();  
        
        {
        System.out.println("Invoking sayHello...");
        com.ddmwsst.helloworld.types.HelloRequest _sayHello_in = new com.ddmwsst.helloworld.types.HelloRequest();
        com.ddmwsst.helloworld.types.HelloResponse _sayHello__return = port.sayHello(_sayHello_in);
        System.out.println("sayHello.result=" + _sayHello__return);


        }

        System.exit(0);
    }

}
