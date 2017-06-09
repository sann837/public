package server;

import com.ddmwsst.helloworld.HelloWorld;
import com.ddmwsst.helloworld.types.HelloRequest;
import com.ddmwsst.helloworld.types.HelloResponse;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public HelloResponse sayHello(HelloRequest in) {
		HelloResponse hres = new HelloResponse();
		hres.setResponseMsg("This is server echoing: " + in.getRequestMsg());
		return hres;
	}

}
