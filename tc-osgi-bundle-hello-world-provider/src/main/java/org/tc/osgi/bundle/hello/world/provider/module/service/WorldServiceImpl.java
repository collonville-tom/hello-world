package org.tc.osgi.bundle.hello.world.provider.module.service;

public class WorldServiceImpl implements IWorldService
{
	@Override
	public String world() {
		return "World";
	}
}
