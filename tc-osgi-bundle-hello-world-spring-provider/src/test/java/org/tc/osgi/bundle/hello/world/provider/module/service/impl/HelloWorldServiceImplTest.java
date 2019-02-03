/**
 */
package org.tc.osgi.bundle.hello.world.provider.module.service.impl;

import org.junit.Test;
import org.tc.osgi.bundle.utils.module.service.impl.UtilsServiceImpl;

/**
 * HelloWorldServiceImplTest.java.
 * @author collonville thomas
 * @version
 * @track
 */
public class HelloWorldServiceImplTest {

    /**
     * test.
     */
    @Test
    public void test() {
        final UtilsServiceImpl utils = new UtilsServiceImpl();
        final HelloWorldServiceImpl impl = new HelloWorldServiceImpl();
        impl.setUtilsService(utils);
        impl.hello();
    }
}
