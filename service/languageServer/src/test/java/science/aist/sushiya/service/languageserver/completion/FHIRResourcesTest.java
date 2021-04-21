/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.completion;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <p>Created by Sophie Bauernfeind on 26.03.2021</p>
 * <p>Test class for {@link FHIRResources}</p>
 *
 * @author Sophie Bauernfeind
 */
public class FHIRResourcesTest {

    @Test
    public void testGetAllFoundation(){
        Assert.assertNotNull(FHIRResources.getInstance().getAllFinancial());
    }

    @Test
    public void testGetAllBase(){
        Assert.assertNotNull(FHIRResources.getInstance().getAllBase());
    }

    @Test
    public void testGetAllClinical(){
        Assert.assertNotNull(FHIRResources.getInstance().getAllClinical());
    }

    @Test
    public void testGetAllFinancial(){
        Assert.assertNotNull(FHIRResources.getInstance().getAllFinancial());
    }

    @Test
    public void testGetAllSpecialized(){
        Assert.assertNotNull(FHIRResources.getInstance().getAllSpecialized());
    }
}
