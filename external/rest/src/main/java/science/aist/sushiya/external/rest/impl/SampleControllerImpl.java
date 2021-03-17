package science.aist.sushiya.external.rest.impl;

import at.fh.hagenberg.aist.jfuck.general.transformer.Transformer;
import science.aist.sushiya.core.domain.Sample;
import science.aist.sushiya.core.dto.SampleDTO;
import science.aist.sushiya.external.rest.SampleController;
import science.aist.sushiya.external.rest.exceptions.ResourceNotFoundException;
import science.aist.sushiya.service.core.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * <p>Created by Andreas Pointner on 29.11.2019</p>
 * <p>Implementation of {@link SampleController}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@SuppressWarnings("squid:S5128") // Suppress validation warning, because it is not possible to add the annotation to insert again. This leads to a mvn clean install error, as it is detected as cascaded validation
@RequiredArgsConstructor
public class SampleControllerImpl implements SampleController {

    /**
     * Sample Service to save in database
     */
    private final SampleService sampleService;

    /**
     * Sample Transformer to transform between object and dto
     */
    private final Transformer<Sample, SampleDTO> sampleToSampleDTOTransformer;

    @Override
    public ResponseEntity<String> insert(SampleDTO item) {
        Sample res = sampleService.save(sampleToSampleDTOTransformer.transformTo(item));

        String uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(res.getId())
                .toUriString();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.LOCATION, uri)
                .build();
    }

    @Override
    public SampleDTO read(Long id) {
        return sampleToSampleDTOTransformer.transformFrom(sampleService.find(id).orElseThrow(ResourceNotFoundException::new));
    }
}
