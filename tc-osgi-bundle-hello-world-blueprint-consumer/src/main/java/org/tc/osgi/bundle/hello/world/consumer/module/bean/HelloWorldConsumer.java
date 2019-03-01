package org.tc.osgi.bundle.hello.world.consumer.module.bean;


import org.tc.osgi.bundle.hello.world.provider.module.service.IWorldService;

public class HelloWorldConsumer {

	private IWorldService service;
	


	public HelloWorldConsumer() {
	}

	public void start(){
		System.out.println("Demarrage du bundle Consumer via BluePrint");
		System.out.println("Hello "+ service.world() + " BluePrint");
	}
	public IWorldService getService() {
		return service;
	}

	public void setService(IWorldService service) {
		this.service = service;
	}
}
