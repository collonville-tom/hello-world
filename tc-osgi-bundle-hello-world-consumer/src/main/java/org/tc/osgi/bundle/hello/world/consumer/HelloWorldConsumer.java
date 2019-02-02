package org.tc.osgi.bundle.hello.world.consumer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.tc.osgi.bundle.hello.world.provider.module.service.IHelloWorldService;
import org.tc.osgi.bundle.utils.module.service.IUtilsService;

/**
 * HelloWorldConsumer.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class HelloWorldConsumer implements ActionListener {
    /**
     * IHelloWorldService helloWorldService.
     */
    private IHelloWorldService helloWorldService;
    /**
     * Timer timer.
     */
    private final Timer timer = new Timer(1000, this);
    /**
     * IUtilsService utilsService.
     */
    private IUtilsService utilsService;

    /**
     * HelloWorldConsumer constructor.
     */
    public HelloWorldConsumer() {
        super();
    }

    /**
     * @param e ActionEvent
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(final ActionEvent e) {

        this.utilsService.getLogger(HelloWorldConsumer.class).debug("Say me hi!");
        this.helloWorldService.hello();

    }

    /**
     * setHelloWorldService.
     * @param helloWorldService IUtilsService
     */
    public void setHelloWorldService(final IHelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    /**
     * setUtilsService.
     * @param utilsService IUtilsService
     */
    public void setUtilsService(final IUtilsService utilsService) {
        this.utilsService = utilsService;
    }

    /**
     * startTimer.
     */
    public void startTimer() {
        this.timer.start();
    }

    /**
     * stopTimer.
     */
    public void stopTimer() {
        this.timer.stop();
    }
}
