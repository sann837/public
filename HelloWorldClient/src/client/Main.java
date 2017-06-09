package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ddmwsst.helloworld.HelloWorld;
import com.ddmwsst.helloworld.types.HelloRequest;
import com.ddmwsst.helloworld.types.HelloResponse;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        HelloWorld helloworld= (HelloWorld) context.getBean("helloClient");
        HelloRequest hreq = new HelloRequest();
        hreq.setRequestMsg("This is client");
        HelloResponse hres = helloworld.sayHello(hreq);
        System.out.println(hres.getResponseMsg());
	}

}