package science.aist.sushiya.external.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Created by Christoph Praschl on 11/02/2019</p>
 * <p>Just a testcontroller interface </p>
 *
 * @author Christoph Praschl christoph.praschl@fh-hagenberg.at
 */
@RequestMapping(value = "/test")
public interface TestController {

  /**
   * just some test echo method
   *
   * @param param given for testing
   * @return Returns some echo message
   */
    @GetMapping(value = "/echo")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    String echo(@RequestParam(value = "param") int param);
}
