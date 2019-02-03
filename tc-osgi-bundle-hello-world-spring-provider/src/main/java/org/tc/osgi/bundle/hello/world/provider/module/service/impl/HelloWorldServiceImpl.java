package org.tc.osgi.bundle.hello.world.provider.module.service.impl;



import org.tc.osgi.bundle.hello.world.provider.module.service.IHelloWorldService;
import org.tc.osgi.bundle.utils.module.service.IUtilsService;

/**
 * HelloWorldServiceImpl.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
    /**
     * IUtilsService utilsService.
     */
    private IUtilsService utilsService = null;

    
//    private final Timer timer = new Timer(1000, (ActionListener) this);
    /**
     * Getter utilsService.
     * @return IUtilsService
     */
    public IUtilsService getUtilsService() {
        return this.utilsService;
    }

    /**
     *
     * @see org.tc.osgi.bundle.hello.world.provider.module.service.IHelloWorldService#hello()
     */
    @Override
    public void hello() {
        this.utilsService.getLogger(HelloWorldServiceImpl.class).debug("Hello World !");

    }

    /**
     * Setter utilsService.
     * @param utilsService IUtilsService
     */
    public void setUtilsService(final IUtilsService utilsService) {
        this.utilsService = utilsService;
        this.utilsService.getLogger(HelloWorldServiceImpl.class).debug("Bean HelloWorldServiceImpl initialise with IUtilsService");
    }
}
