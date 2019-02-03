package org.tc.osgi.bundle.hello.world.consumer.module.tracker;

import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.tc.osgi.bundle.hello.world.provider.module.service.IWorldService;

public class WorldServiceTracker extends ServiceTracker {

    public WorldServiceTracker(final BundleContext context) throws InvalidSyntaxException, BundleException {
        super(context, IWorldService.class.getName(), null);
    }

    @Override
    public Object addingService(final ServiceReference reference) {
        System.out.println("Inside WorldServiceTracker.addingService " + reference.getBundle());
        return super.addingService(reference);
    }

    public IWorldService getWorldService() {
        return (IWorldService) super.getService();
    }

    @Override
    public void removedService(final ServiceReference reference, final Object service) {
        System.out.println("Inside WorldServiceTracker.removedService " + reference.getBundle());
        super.removedService(reference, service);
    }
}
