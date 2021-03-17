package science.aist.sushiya.external.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpInputMessage;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeClass;

import java.nio.charset.StandardCharsets;

/**
 * @author Oliver Krauss on 25.03.2015.
 */
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:controllerConfig.xml"})
public abstract class AbstractRestControllerTest extends AbstractTestNGSpringContextTests {

    protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            StandardCharsets.UTF_8);

    protected MockMvc mockMvc;

    protected HttpMessageConverter<Object> mappingJackson2HttpMessageConverter;

    @Autowired
    protected WebApplicationContext webApplicationContext;


    @BeforeClass
    public void setup() {
        this.mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @SneakyThrows
    protected String json(Object o)  {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    @SneakyThrows
    protected <T> T obj(String json, Class<T> tClass) {
        return new ObjectMapper().readValue(json, tClass);
    }
}
