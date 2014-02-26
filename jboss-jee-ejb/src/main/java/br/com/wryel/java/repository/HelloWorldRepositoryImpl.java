package br.com.wryel.java.repository;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import br.com.wryel.java.entity.HelloWorld;

@Stateless
public class HelloWorldRepositoryImpl implements HelloWorldRepository {
	
	public void insert(HelloWorld helloWorld) {
		
	}

	public List<HelloWorld> list() {
		
		HelloWorld helloWorldUm = new HelloWorld();
		helloWorldUm.setString("Hello");
		
		HelloWorld helloWorldDois = new HelloWorld();
		helloWorldDois.setString("World");
		
		return Arrays.asList(helloWorldUm, helloWorldDois);
	}
}
