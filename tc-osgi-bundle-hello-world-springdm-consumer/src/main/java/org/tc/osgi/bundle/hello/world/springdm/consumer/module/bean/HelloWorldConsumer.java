package org.tc.osgi.bundle.hello.world.springdm.consumer.module.bean;


import org.tc.osgi.bundle.hello.world.provider.module.service.IWorldService;

public class HelloWorldConsumer {

	private IWorldService service;
	


	public HelloWorldConsumer() {
	}

	public void start(){
		System.out.println("Demarrage du bundle Consumer via SpringDM");
		System.out.println("Hello "+ service.world() + " SpringDM");
	}
	public IWorldService getService() {
		return service;
	}

	public void setService(IWorldService service) {
		this.service = service;
	}
}
