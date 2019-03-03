package org.tc.osgi.bundle.hello.world.provider.annot.module.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component
public class WorldServiceImpl implements IWorldService
{
	@Activate
	public void start() throws Exception {
		System.out.println("Demarrage du bundle Provider via SCR");	
	}

	@Deactivate
	public void deactivate() throws Exception {
		System.out.println("Fermeture du bundle Provider via SCR");
	}
	
	@Override
	public String world() {
		return "World";
	}
}
