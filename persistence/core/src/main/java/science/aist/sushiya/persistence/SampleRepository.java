package science.aist.sushiya.persistence;

import science.aist.sushiya.core.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>Repository for Domainclass {@link Sample}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
public interface SampleRepository extends JpaRepository<Sample, Long> {
}
