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

public class HoverProvider implements Function<HoverParams,Hover> {
    private static final ProviderHelper HELPER = new ProviderHelper();
    private static String infoText;

    @Override
    public Hover apply(HoverParams params) {
        MarkupContent markupContent = new MarkupContent();
        markupContent.setKind("plaintext");

        String searchedInformation = HELPER.getName(
                FSHFileHandler.getInstance().getFile(params.getTextDocument()),
                params.getPosition());

        if(searchedInformation == null){
            return new Hover(markupContent);
        }

        searchedInformation = searchedInformation.toUpperCase(Locale.ROOT);

        if(checkForEntity(searchedInformation)){
            markupContent.setValue(infoText);
            return new Hover(markupContent);
        }else if(checkForMetadata(searchedInformation)){
            markupContent.setValue(infoText);
            return new Hover(markupContent);
        }

        return new Hover(markupContent);
    }

    private boolean checkForEntity(String name){
        try{
            Entity searchedInformationEntity = Entity.valueOf(name);
            switch (searchedInformationEntity){
                case ALIAS:
                    infoText = AdditionalInformation.aliasInformation;
                    break;
                case PROFILE:
                    infoText = AdditionalInformation.profileInformation;
                    break;
                case EXTENSION:
                    infoText = AdditionalInformation.extensionInformation;
                    break;
                case INVARIANT:
                    infoText = AdditionalInformation.invariantInformation;
                    break;
                case INSTANCE:
                    infoText = AdditionalInformation.instanceInformation;
                    break;
                case VALUESET:
                    infoText = AdditionalInformation.valueSetInformation;
                    break;
                case CODESYSTEM:
                    infoText = AdditionalInformation.codeSystemInformation;
                    break;
                case RULESET:
                    infoText = AdditionalInformation.ruleSetInformation;
                    break;
                case MAPPING:
                    infoText = AdditionalInformation.mappingInformation;
                    break;
                default:
                    return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private boolean checkForMetadata(String name){
        try{
            Metadata searchedInformationEntity = Metadata.valueOf(name);
            switch (searchedInformationEntity){
                case DESCRIPTION:
                    infoText = AdditionalInformation.descriptionInformation;
                    break;
                case EXPRESSION:
                    infoText = AdditionalInformation.extensionInformation;
                    break;
                case ID:
                    infoText = AdditionalInformation.idInformation;
                    break;
                case INSTANCEOF:
                    infoText = AdditionalInformation.instanceOfInformation;
                    break;
                case PARENT:
                    infoText = AdditionalInformation.parentInformation;
                    break;
                case SEVERITY:
                    infoText = AdditionalInformation.severityInformation;
                    break;
                case SOURCE:
                    infoText = AdditionalInformation.sourceInformation;
                    break;
                case TARGET:
                    infoText = AdditionalInformation.targetInformation;
                    break;
                case TITLE:
                    infoText = AdditionalInformation.titleInformation;
                    break;
                case USAGE:
                    infoText = AdditionalInformation.usageInformation;
                    break;
                case XPATH:
                    infoText = AdditionalInformation.xpathInformation;
                    break;
                case MIXINS:
                    infoText = AdditionalInformation.mixinsInformation;
                    break;
                default:
                    return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
