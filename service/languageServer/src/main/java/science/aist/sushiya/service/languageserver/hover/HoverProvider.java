/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.hover;

import org.eclipse.lsp4j.Hover;
import org.eclipse.lsp4j.HoverParams;
import org.eclipse.lsp4j.MarkupContent;
import science.aist.sushiya.service.languageserver.*;

import java.util.Locale;
import java.util.function.Function;

/**
 * <p>For a better structure of the server, the hover requests will be handled here.</p>
 *
 * @author SophieBauernfeind
 */

public class HoverProvider implements Function<HoverParams, Hover> {
    private static final ProviderHelper HELPER = new ProviderHelper();
    private static String infoText;

    @Override
    public Hover apply(HoverParams params) {
        MarkupContent markupContent = new MarkupContent();
        markupContent.setKind("plaintext");

        String searchedInformation = HELPER.getName(
                FSHFileHandler.getInstance().getFile(params.getTextDocument()),
                params.getPosition());

        if (searchedInformation == null) {
            return new Hover(markupContent);
        }

        searchedInformation = searchedInformation.toUpperCase(Locale.ROOT);

        if (checkForEntity(searchedInformation)) {
            markupContent.setValue(infoText);
            return new Hover(markupContent);
        } else if (checkForMetadata(searchedInformation)) {
            markupContent.setValue(infoText);
            return new Hover(markupContent);
        }

        return new Hover(markupContent);
    }

    private boolean checkForEntity(String name) {
        try {
            Entity searchedInformationEntity = Entity.valueOf(name);
            switch (searchedInformationEntity) {
                case ALIAS:
                    infoText = AdditionalInformation.ALIAS_INFORMATION;
                    break;
                case PROFILE:
                    infoText = AdditionalInformation.PROFILE_INFORMATION;
                    break;
                case EXTENSION:
                    infoText = AdditionalInformation.EXTENSION_INFORMATION;
                    break;
                case INVARIANT:
                    infoText = AdditionalInformation.INVARIANT_INFORMATION;
                    break;
                case INSTANCE:
                    infoText = AdditionalInformation.INSTANCE_INFORMATION;
                    break;
                case VALUESET:
                    infoText = AdditionalInformation.VALUE_SET_INFORMATION;
                    break;
                case CODESYSTEM:
                    infoText = AdditionalInformation.CODE_SYSTEM_INFORMATION;
                    break;
                case RULESET:
                    infoText = AdditionalInformation.RULE_SET_INFORMATION;
                    break;
                case MAPPING:
                    infoText = AdditionalInformation.MAPPING_INFORMATION;
                    break;
                default:
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean checkForMetadata(String name) {
        try {
            Metadata searchedInformationEntity = Metadata.valueOf(name);
            switch (searchedInformationEntity) {
                case DESCRIPTION:
                    infoText = AdditionalInformation.DESCRIPTION_INFORMATION;
                    break;
                case EXPRESSION:
                    infoText = AdditionalInformation.EXTENSION_INFORMATION;
                    break;
                case ID:
                    infoText = AdditionalInformation.ID_INFORMATION;
                    break;
                case INSTANCEOF:
                    infoText = AdditionalInformation.INSTANCE_OF_INFORMATION;
                    break;
                case PARENT:
                    infoText = AdditionalInformation.PARENT_INFORMATION;
                    break;
                case SEVERITY:
                    infoText = AdditionalInformation.SEVERITY_INFORMATION;
                    break;
                case SOURCE:
                    infoText = AdditionalInformation.SOURCE_INFORMATION;
                    break;
                case TARGET:
                    infoText = AdditionalInformation.TARGET_INFORMATION;
                    break;
                case TITLE:
                    infoText = AdditionalInformation.TITLE_INFORMATION;
                    break;
                case USAGE:
                    infoText = AdditionalInformation.USAGE_INFORMATION;
                    break;
                case XPATH:
                    infoText = AdditionalInformation.XPATH_INFORMATION;
                    break;
                case MIXINS:
                    infoText = AdditionalInformation.MIXINS_INFORMATION;
                    break;
                default:
                    return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
