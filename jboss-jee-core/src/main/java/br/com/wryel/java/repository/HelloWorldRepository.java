package br.com.wryel.java.repository;

import java.util.List;

import javax.ejb.Local;

import br.com.wryel.java.entity.HelloWorld;

@Local
public interface HelloWorldRepository {

	public void insert(HelloWorld helloWorld);
	
	public List<HelloWorld> list();
}
