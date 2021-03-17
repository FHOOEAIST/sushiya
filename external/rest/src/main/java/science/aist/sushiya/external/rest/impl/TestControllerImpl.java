package science.aist.sushiya.external.rest.impl;

import science.aist.sushiya.external.rest.TestController;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * <p>Created by Christoph Praschl on 11/02/2019</p>
 * <p>Just a testcontroller implementation</p>
 * <p>
 * Try it with calling: http://localhost:12345/external/test/echo?param=123
 *
 * @author Christoph Praschl christoph.praschl@fh-hagenberg.at
 */
public class TestControllerImpl implements TestController {
    @Override
    public String echo(@RequestParam int param) {
        return "Echo param (" + param + ");";
    }
}
