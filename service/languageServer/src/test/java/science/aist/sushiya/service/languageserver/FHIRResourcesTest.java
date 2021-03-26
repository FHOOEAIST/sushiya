package science.aist.sushiya.service.languageserver;

import org.testng.Assert;
import org.testng.annotations.Test;
import science.aist.sushiya.service.languageserver.completion.FHIRResources;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link FHIRResources}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FHIRResourcesTest {

    @Test
    public void testGetAllFoundation(){
        //given

        //when

        //then
        Assert.assertNotNull(FHIRResources.getInstance().getAllFinancial());
    }

    @Test
    public void testGetAllBase(){
        //given

        //when

        //then
        Assert.assertNotNull(FHIRResources.getInstance().getAllBase());
    }

    @Test
    public void testGetAllClinical(){
        //given

        //when

        //then
        Assert.assertNotNull(FHIRResources.getInstance().getAllClinical());
    }

    @Test
    public void testGetAllFinancial(){
        //given

        //when

        //then
        Assert.assertNotNull(FHIRResources.getInstance().getAllFinancial());
    }

    @Test
    public void testGetAllSpecialized(){
        //given

        //when

        //then
        Assert.assertNotNull(FHIRResources.getInstance().getAllSpecialized());
    }
}
