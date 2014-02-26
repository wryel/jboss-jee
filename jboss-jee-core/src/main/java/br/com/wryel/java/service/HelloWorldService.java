package br.com.wryel.java.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.wryel.java.entity.HelloWorld;

@Remote
public interface HelloWorldService {

	public void insert(HelloWorld helloWorld);
	
	public List<HelloWorld> list();
}
