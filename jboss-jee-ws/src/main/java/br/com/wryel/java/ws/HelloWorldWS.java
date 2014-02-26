package br.com.wryel.java.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.wryel.java.entity.HelloWorld;
import br.com.wryel.java.service.HelloWorldService;
import br.com.wryel.java.service.ServiceLocator;

@Path("/helloWorldWS")
public class HelloWorldWS {

	public void insert(HelloWorld helloWorld) {
		HelloWorldService lookupHelloWorldService = ServiceLocator.getInstance().lookupHelloWorldService();
		lookupHelloWorldService.insert(helloWorld);
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HelloWorld> list() {
		// http://stackoverflow.com/questions/3027834/inject-a-ejb-into-jax-rs-restfull-service
		HelloWorldService lookupHelloWorldService = ServiceLocator.getInstance().lookupHelloWorldService();
		return lookupHelloWorldService.list();
	}
}
