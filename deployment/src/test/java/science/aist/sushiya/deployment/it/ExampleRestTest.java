package science.aist.sushiya.deployment.it;

import at.fh.hagenberg.aist.seshat.Logger;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@ContextConfiguration(locations = {"classpath*:controllerConfigTest.xml"})
public class ExampleRestTest extends AbstractTestNGSpringContextTests {
    private static final Logger logger = Logger.getInstance(ExampleRestTest.class);
    private static final String HOST = "http://localhost:12345/sushiya";
    private final String path = "/test/echo";
    private RestTemplate restTemplate;

    /**
     * @return a plain http entity
     */
    protected HttpEntity<?> getPlainEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new HttpEntity<>(headers);
    }

    @BeforeClass
    public void setup() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    }

    @BeforeMethod
    protected void beforeMethod(Method method) {
        logger.info("Started " + method.getName());
    }

    @AfterMethod
    protected void afterMethod(Method method) {
        logger.info("Completed " + method.getName());
    }

    @Test
    public void testIntegrationExample() {
        // given
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(HOST + path).queryParam("param", 42);
        HttpEntity<?> entity = getPlainEntity();

        // when
        ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

        // then
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "Echo param (42);");
    }
}
