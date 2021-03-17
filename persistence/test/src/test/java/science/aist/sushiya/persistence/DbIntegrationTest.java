package science.aist.sushiya.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>Base test class for Db Integration Tests</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
@ContextConfiguration(locations = {"classpath*:repositoryConfig.xml"})
public abstract class DbIntegrationTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected SampleRepository sampleRepository;

    @AfterMethod(alwaysRun = true)
    public void clean() {
        sampleRepository.deleteAll();
    }
}
