/**
 */
package org.tc.osgi.bundle.hello.world.provider.module.activator;



import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.tc.osgi.bundle.hello.world.provider.module.service.IWorldService;
import org.tc.osgi.bundle.hello.world.provider.module.service.WorldServiceFactory;
import org.tc.osgi.bundle.hello.world.provider.module.service.WorldServiceImpl;


public class HelloWorldProviderActivator implements BundleActivator {

	private ServiceRegistration serviceReg;
 
	public HelloWorldProviderActivator() {   }
    
    @Override
    public void start(final BundleContext context) throws Exception {
    	System.out.println("Demarrage du bundle Provider");
    	WorldServiceFactory factory=new WorldServiceFactory(new WorldServiceImpl());
    	this.serviceReg=context.registerService(IWorldService.class.getName(),factory, null);
    	System.out.println("Enregistrement du service World");
    }

    @Override
    public void stop(final BundleContext context) throws Exception {
    	serviceReg.unregister();
    }
}
