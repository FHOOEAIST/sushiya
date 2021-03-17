package science.aist.sushiya.persistence;

import science.aist.sushiya.core.domain.Sample;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>{@link SampleRepository} test</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */
public class SampleRepositoryTest extends DbIntegrationTest {
    @Test
    public void testSave() {
        // given
        Sample s = new Sample("Test");

        // when
        s = sampleRepository.save(s);

        // then
        Assert.assertNotNull(s);
        Assert.assertNotNull(s.getId());
    }

    @Test
    public void testLoad() {
        // given
        Sample s = new Sample("Test");
        s = sampleRepository.save(s);

        // when
        Optional<Sample> loadOpt = sampleRepository.findById(s.getId());

        // then
        Assert.assertNotNull(loadOpt);
        Assert.assertTrue(loadOpt.isPresent());
        Assert.assertEquals(loadOpt.orElseThrow(), s);
    }

    @Test
    public void testLoadAll() {
        // given
        Sample s1 = new Sample("Test1");
        s1 = sampleRepository.save(s1);
        Sample s2 = new Sample("Test2");
        s2 = sampleRepository.save(s2);

        // when
        List<Sample> all = sampleRepository.findAll();

        // then
        Assert.assertNotNull(all);
        Assert.assertEquals(all.size(), 2);
        Assert.assertTrue(all.contains(s1));
        Assert.assertTrue(all.contains(s2));
    }
}
