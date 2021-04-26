/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver;

/**
 * <p>This enum contains all entities of fhir-shorthand.</p>
 * <p>09.04.21, version 1.1.0</p>
 *
 * @author SophieBauernfeind
 */

public enum Entity {
    ALIAS,
    PROFILE,
    EXTENSION,
    INVARIANT,
    INSTANCE,
    VALUESET,
    CODESYSTEM,
    RULESET,
    MAPPING
}
