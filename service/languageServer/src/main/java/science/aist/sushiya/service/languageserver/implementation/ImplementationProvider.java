/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.implementation;

import org.eclipse.lsp4j.ImplementationParams;
import org.eclipse.lsp4j.Location;
import org.eclipse.lsp4j.LocationLink;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import science.aist.sushiya.service.languageserver.FSHFileHandler;
import science.aist.sushiya.service.languageserver.ProviderHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * <p>The implementation provider handles the incoming implementation requests and provides a list of locations.</p>
 *
 * @author SophieBauernfeind
 */
public class ImplementationProvider implements Function<ImplementationParams,
        Either<List<? extends Location>, List<? extends LocationLink>>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ImplementationParams.class);
    private static final String regexUsingMetadata= "(Expression|InstanceOf|Parent|Source|Target)";
    private static final ProviderHelper locationHelper = new ProviderHelper();

    @Override
    public Either<List<? extends Location>, List<? extends LocationLink>> apply(ImplementationParams implementationParams) {
        String searchedImplementations = locationHelper.getName(
                FSHFileHandler.getInstance().getFile(implementationParams.getTextDocument()),
                implementationParams.getPosition());

        if(searchedImplementations == null){
            return Either.forLeft(new ArrayList<>());
        }

        return Either.forLeft(locationHelper.getLocations(searchedImplementations,
                "\\s*"+ regexUsingMetadata +"\\s*:\\s+" + searchedImplementations + "\\s*"));
    }

}
