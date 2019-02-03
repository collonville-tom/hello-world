package org.tc.osgi.bundle.hello.world.provider.module.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.ServiceFactory;
import org.osgi.framework.ServiceRegistration;

public class WorldServiceFactory implements ServiceFactory{

	private IWorldService instance;

	public WorldServiceFactory(IWorldService instance) {
		super();
		this.instance = instance;
	}
	
	@Override
	public Object getService(Bundle bundle, ServiceRegistration registration) {
		System.out.println("Obtention du service WorldServiceFactory");
		return instance;
	}

	@Override
	public void ungetService(Bundle bundle, ServiceRegistration registration, Object service) {
		System.out.println("Relachement du service WorldServiceFactory");
		
	}
}
