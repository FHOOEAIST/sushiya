package science.aist.sushiya.core.transformer;

import science.aist.sushiya.core.domain.Sample;
import science.aist.sushiya.core.dto.SampleDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Test class for {@link SampleToSampleDTOTransformer}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */

public class SampleToSampleDTOTransformerTest {

    private final SampleToSampleDTOTransformer transformer = new SampleToSampleDTOTransformer();

    @Test
    public void testTransformTo() {
        // given
        SampleDTO sDto = new SampleDTO("abc");

        // when
        Sample s = transformer.transformTo(sDto);

        // then
        Assert.assertNotNull(s);
        Assert.assertEquals(s.getSampleData(), sDto.getSampleData());
    }

    @Test
    public void testTransformFrom() {
        // given
        Sample s = new Sample("abc");

        // when
        SampleDTO sDto = transformer.transformFrom(s);

        // then
        Assert.assertNotNull(sDto);
        Assert.assertEquals(sDto.getSampleData(), s.getSampleData());
    }
}