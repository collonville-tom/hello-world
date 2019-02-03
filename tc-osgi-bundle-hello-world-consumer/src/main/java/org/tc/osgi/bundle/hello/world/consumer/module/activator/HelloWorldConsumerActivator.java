/**
 */
package org.tc.osgi.bundle.hello.world.consumer.module.activator;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.hello.world.consumer.module.tracker.WorldServiceTracker;
import org.tc.osgi.bundle.hello.world.provider.module.service.IWorldService;

public class HelloWorldConsumerActivator implements BundleActivator {

	public HelloWorldConsumerActivator() {
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		System.out.println("Demarrage du bundle Consumer");
		WorldServiceTracker tracker=new WorldServiceTracker(context);
		tracker.open();
		IWorldService service=tracker.getWorldService();
		System.out.println("Hello "+ service.world());
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
	}
}
