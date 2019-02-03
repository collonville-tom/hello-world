/**
 */
package org.tc.osgi.bundle.hello.world.consumer;

import java.awt.event.ActionEvent;

import org.junit.Test;
import org.tc.osgi.bundle.hello.world.provider.module.service.impl.HelloWorldServiceImpl;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

/**
 * HelloWorldConsumerTest.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class HelloWorldConsumerTest {

    /**
     * test.
     */
    @Test
    public void test() {
        final UtilsServiceImpl utils = new UtilsServiceImpl();
        final HelloWorldServiceImpl provider = new HelloWorldServiceImpl();
        provider.setUtilsService(utils);

        final HelloWorldConsumer con = new HelloWorldConsumer();
        con.setUtilsService(utils);
        con.setHelloWorldService(provider);

        con.startTimer();
        con.actionPerformed(new ActionEvent(con, 0, null));
        con.stopTimer();
    }

}
