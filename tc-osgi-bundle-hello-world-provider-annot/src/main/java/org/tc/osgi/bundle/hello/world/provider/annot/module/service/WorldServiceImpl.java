package org.tc.osgi.bundle.hello.world.provider.annot.module.service;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

@Component(service=IWorldService.class)
public class WorldServiceImpl implements IWorldService
{
	@Activate
	public void active()
	{
		System.out.println("Provider Run with SCR");
	}
	
	@Override
	public String world() {
		return "World";
	}
}
