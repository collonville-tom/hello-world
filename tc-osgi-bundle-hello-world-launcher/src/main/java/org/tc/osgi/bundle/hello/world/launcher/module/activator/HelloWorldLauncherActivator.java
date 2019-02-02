/**
 */
package org.tc.osgi.bundle.hello.world.launcher.module.activator;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.InvalidSyntaxException;
import org.tc.osgi.bundle.hello.world.launcher.module.service.UtilsServiceProxy;
import org.tc.osgi.bundle.hello.world.launcher.module.tracker.UtilsServiceTracker;
import org.tc.osgi.bundle.utils.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.logger.LoggerGestionnary;

/**
 * HelloWorldLauncher.java.
 * @author collonville thomas
 * @version
 */
public class HelloWorldLauncherActivator implements BundleActivator {

    /**
     * String HELLO_WORLD_CONSUMER.
     */
    public static final String HELLO_WORLD_CONSUMER = "tc-osgi-bundle-hello-world-consumer";
    /**
     * String HELLO_WORLD_PROVIDER.
     */
    public static final String HELLO_WORLD_PROVIDER = "tc-osgi-bundle-hello-world-provider";

    /**
     * UtilsServiceTracker utilsServiceTracker.
     */
    private UtilsServiceTracker utilsServiceTracker;

    /**
     * HelloWorldLauncherActivator constructor.
     */
    public HelloWorldLauncherActivator() {

    }

    /**
     * activeUtilsServiceTracker.
     * @param context BundleContext
     * @throws InvalidSyntaxException
     * @throws BundleException
     */
    private void activeUtilsServiceTracker(final BundleContext context) throws InvalidSyntaxException, BundleException {
        this.utilsServiceTracker = new UtilsServiceTracker(context);
        this.utilsServiceTracker.open();
        UtilsServiceProxy.getInstance().setService(this.utilsServiceTracker.getUtilsService());
        UtilsServiceProxy.getInstance().getLogger(HelloWorldLauncherActivator.class).debug("Start of utils service tracking");

    }

    /**
     * start.
     * @throws NumberFormatException
     * @throws FieldTrackingAssignementException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws UnknownHostException
     * @throws BundleException
     * @throws NotBoundException
     */
    public void start() throws NumberFormatException, FieldTrackingAssignementException, MalformedURLException, RemoteException,
    UnknownHostException, BundleException, NotBoundException {

    }

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        this.activeUtilsServiceTracker(context);
        UtilsServiceProxy.getInstance().getBundleStarter().startBundle(context, HelloWorldLauncherActivator.HELLO_WORLD_PROVIDER);
        UtilsServiceProxy.getInstance().getBundleStarter().startBundle(context, HelloWorldLauncherActivator.HELLO_WORLD_CONSUMER);

    }

    /**
     * stop.
     * @throws NumberFormatException
     * @throws FieldTrackingAssignementException
     * @throws MalformedURLException
     * @throws RemoteException
     * @throws UnknownHostException
     * @throws BundleException
     * @throws NotBoundException
     */
    public void stop() throws NumberFormatException, FieldTrackingAssignementException, MalformedURLException, RemoteException,
    UnknownHostException, BundleException, NotBoundException {

    }

    /**
     * @param context BundleContext
     * @throws Exception
     * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        UtilsServiceProxy.getInstance().getBundleKiller().stopBundle(context, HelloWorldLauncherActivator.HELLO_WORLD_CONSUMER);
        UtilsServiceProxy.getInstance().getBundleKiller().stopBundle(context, HelloWorldLauncherActivator.HELLO_WORLD_PROVIDER);
        this.stopUtilsServiceTracker();

    }

    /**
     * stopUtilsServiceTracker.
     */
    private void stopUtilsServiceTracker() {
        LoggerGestionnary.getInstance(HelloWorldLauncherActivator.class).debug("Stop of utils service tracking");
        this.utilsServiceTracker.close();
    }
}
