package science.aist.sushiya.core.transformer;

import at.fh.hagenberg.aist.jfuck.general.PropertyMapperCreator;
import at.fh.hagenberg.aist.jfuck.general.transformer.Transformer;
import science.aist.sushiya.core.domain.Sample;
import science.aist.sushiya.core.dto.SampleDTO;
import lombok.CustomLog;

import javax.validation.Valid;
import java.util.function.Function;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Transformer to transform {@link Sample} to {@link SampleDTO}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@CustomLog
public class SampleToSampleDTOTransformer implements Transformer<Sample, SampleDTO> {

    private static final Function<Sample, @Valid SampleDTO> toDto = new PropertyMapperCreator<Sample, SampleDTO>()
            .from(Sample::getSampleData).to(SampleDTO::setSampleData)
            .create(SampleDTO::new);

    private static final Function<@Valid SampleDTO, Sample> toObj = new PropertyMapperCreator<SampleDTO, Sample>()
            .from(SampleDTO::getSampleData).to(Sample::setSampleData)
            .create(Sample::new);

    @Override
    public Sample transformTo(SampleDTO sampleDTO) {
        log.debug("TransformTo: " + sampleDTO);
        return toObj.apply(sampleDTO);
    }

    @Override
    public SampleDTO transformFrom(Sample sample) {
        log.debug("TransformFrom: " + sample);
        return toDto.apply(sample);
    }
}
