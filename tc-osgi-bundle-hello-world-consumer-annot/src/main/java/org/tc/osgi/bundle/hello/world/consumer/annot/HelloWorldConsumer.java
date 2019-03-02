package org.tc.osgi.bundle.hello.world.consumer.annot;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.tc.osgi.bundle.hello.world.provider.annot.module.service.IWorldService;

@Component
public class HelloWorldConsumer {

	@Reference
	private IWorldService service;

	public HelloWorldConsumer() {
	}

	@Activate
	public void start() throws Exception {
		System.out.println("Demarrage du bundle Consumer via SCR");
		System.out.println("Hello " + service.world() + " SCR");
	}

	public IWorldService getService() {
		return service;
	}

	public void setService(IWorldService service) {
		this.service = service;
	}

	@Deactivate
	public void deactivate() throws Exception {
		System.out.println("Fermeture du bundle Consumer via SCR");
	}
}
