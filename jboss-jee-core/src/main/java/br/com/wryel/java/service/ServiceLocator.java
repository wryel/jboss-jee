package br.com.wryel.java.service;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.wryel.java.JBossJEERuntimeException;

public class ServiceLocator {

	private static final ServiceLocator INSTANCE = new ServiceLocator();
	
	public static ServiceLocator getInstance() {
		return INSTANCE;
	}
	
	private ServiceLocator() {
		
	}
	
	private <SERVICE> SERVICE lookupService(Class<SERVICE> serviceClass) {
		try {
			return InitialContext.doLookup("java:app/jboss-jee-ejb-1.0.0-SNAPSHOT/" + serviceClass.getSimpleName() + "Impl");
		} catch (NamingException e) {
			throw new JBossJEERuntimeException("Erro ao fazer lookup de " + HelloWorldService.class.getSimpleName(), e);
		}
	}
	
	public HelloWorldService lookupHelloWorldService() {
		
		/**
		   Strings para lookup no JBoss 7, as que começam com java:module não funcionaram (ver documentação do JBoss 7)
		   
		   java:global/jboss-jee-ear/jboss-jee-ejb-1.0.0-SNAPSHOT/HelloWorldServiceImpl!br.com.wryel.java.service.HelloWorldService
	       java:app/jboss-jee-ejb-1.0.0-SNAPSHOT/HelloWorldServiceImpl!br.com.wryel.java.service.HelloWorldService
	       java:module/HelloWorldServiceImpl!br.com.wryel.java.service.HelloWorldService
	       java:jboss/exported/jboss-jee-ear/jboss-jee-ejb-1.0.0-SNAPSHOT/HelloWorldServiceImpl!br.com.wryel.java.service.HelloWorldService
	       java:global/jboss-jee-ear/jboss-jee-ejb-1.0.0-SNAPSHOT/HelloWorldServiceImpl
	       java:app/jboss-jee-ejb-1.0.0-SNAPSHOT/HelloWorldServiceImpl
	       java:module/HelloWorldServiceImpl
	       
	       
		 */
		
		return lookupService(HelloWorldService.class);
	}
}
