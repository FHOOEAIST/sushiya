package science.aist.sushiya.service.core.impl;

import science.aist.sushiya.core.domain.Sample;
import science.aist.sushiya.persistence.SampleRepository;
import science.aist.sushiya.service.core.SampleService;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>Sample Service Implementation for {@link Sample} domain class</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
public class SampleServiceImpl extends AbstractService<Sample, Long, SampleRepository> implements SampleService {
    public SampleServiceImpl(SampleRepository repository) {
        super(repository);
    }
}
