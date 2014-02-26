package br.com.wryel.java.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.wryel.java.entity.HelloWorld;
import br.com.wryel.java.repository.HelloWorldRepository;

@Stateless
public class HelloWorldServiceImpl implements HelloWorldService {

	@EJB
	private HelloWorldRepository helloWorldRepository;
	
	public void insert(HelloWorld helloWorld) {
		helloWorldRepository.insert(helloWorld);
	}

	public List<HelloWorld> list() {
		return helloWorldRepository.list();
	}
}
