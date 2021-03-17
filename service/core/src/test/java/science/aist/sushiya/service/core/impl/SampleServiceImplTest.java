package science.aist.sushiya.service.core.impl;

import science.aist.sushiya.core.domain.Sample;
import science.aist.sushiya.persistence.SampleRepository;
import science.aist.sushiya.service.core.SampleService;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * <p>Created by Andreas Pointner on 15.11.2019</p>
 * <p>Test class for {@link SampleServiceImpl}</p>
 *
 * @author Andreas Pointner andreas.pointner@fh-hagenberg.at
 */

public class SampleServiceImplTest {
    @Test
    public void testSave() {
        // given
        Sample s = new Sample("test");
        SampleRepository sampleRepository = Mockito.mock(SampleRepository.class);
        Mockito.when(sampleRepository.save(s)).thenReturn(s);
        SampleService ss = new SampleServiceImpl(sampleRepository);

        // when
        Sample save = ss.save(s);

        // then
        Assert.assertNotNull(save);
        Mockito.verify(sampleRepository, Mockito.times(1)).save(s);
    }

    @Test
    public void testFind() {
        // given
        Sample s = new Sample("test"); // Let's just say, that this has an id of 42
        SampleRepository sampleRepository = Mockito.mock(SampleRepository.class);
        Mockito.when(sampleRepository.findById(42L)).thenReturn(Optional.of(s));
        SampleService ss = new SampleServiceImpl(sampleRepository);

        // when
        Sample save = ss.find(42L).orElse(null);

        // then
        Assert.assertNotNull(save);
        Assert.assertEquals(save, s);
        Mockito.verify(sampleRepository, Mockito.times(1)).findById(42L);
    }

    @Test
    public void testFindAll() {
        // given
        Sample s = new Sample("test"); // Let's just say, that this has an id of 42
        Sample s2 = new Sample("test2"); // Let's just say, that this has an id of 42
        SampleRepository sampleRepository = Mockito.mock(SampleRepository.class);
        Mockito.when(sampleRepository.findAll()).thenReturn(Arrays.asList(s, s2));
        SampleService ss = new SampleServiceImpl(sampleRepository);

        // when
        Collection<Sample> all = ss.findAll();

        // then
        Assert.assertNotNull(all);
        Assert.assertTrue(all.contains(s));
        Assert.assertTrue(all.contains(s2));
        Mockito.verify(sampleRepository, Mockito.times(1)).findAll();
    }
}