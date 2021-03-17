package science.aist.sushiya.external.rest.impl;

import science.aist.sushiya.core.dto.SampleDTO;
import science.aist.sushiya.external.rest.AbstractRestControllerTest;
import science.aist.sushiya.external.rest.ControllerConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Test class for {@link SampleControllerImpl}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */

public class SampleControllerImplTest extends AbstractRestControllerTest {

    private static final String ERRORS = "errors";

    @Test
    public void testInsert() throws Exception {
        // given
        SampleDTO sampleDTO = new SampleDTO("test");

        // when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders
                .post(ControllerConstant.SAMPLE_ENDPOINT)
                .content(json(sampleDTO))
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        perform.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.redirectedUrlPattern("http://localhost/sample/*"));
    }

    @Test
    public void testInsertNotValid() throws Exception {
        // given
        SampleDTO sampleDTO = new SampleDTO();

        // when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders
                .post(ControllerConstant.SAMPLE_ENDPOINT)
                .content(json(sampleDTO))
                .contentType(contentType)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print()
        );

        // then
        String contentAsString = perform.andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Map<?, ?> content = obj(contentAsString, HashMap.class);
        Assert.assertNotNull(content);
        Assert.assertTrue(content.containsKey(ERRORS));
        Assert.assertNotNull(content.get(ERRORS));
        Assert.assertTrue(content.get(ERRORS) instanceof Map);
        Map<?, ?> errors = ( Map<?, ?>) content.get(ERRORS);
        Assert.assertTrue(errors.containsKey("sampleData"));
        Assert.assertEquals(errors.get("sampleData"), "Please provide sampleData");
    }

    @Test
    public void testRead() throws Exception {
        // given
        SampleDTO sampleDTO = new SampleDTO("test");
        String location = String.valueOf(mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ControllerConstant.SAMPLE_ENDPOINT)
                        .content(json(sampleDTO))
                        .contentType(contentType)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getHeaderValue(HttpHeaders.LOCATION));

        // when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders
                .get(location)
                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        perform.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testReadNonExisting() throws Exception {
        // given

        // when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders
                .get(ControllerConstant.SAMPLE_ENDPOINT + "/{id}", -1)
                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        perform.andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}