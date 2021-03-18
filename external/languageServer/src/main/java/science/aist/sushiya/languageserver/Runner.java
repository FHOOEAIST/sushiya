/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package science.aist.sushiya.languageserver;

import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.launch.LSPLauncher;
import org.eclipse.lsp4j.services.LanguageClient;

import java.util.Arrays;
import java.util.List;

//create when websocket is needed
//import science.aist.sushiya.languageserver.websocket.WebSocketRunner;

/**
 * @author lhein
 *
 * @author SophieBauernfeind - replaced "Camel" with "FSH"
 */
public class Runner {

    /**
     * For test only
     */
    static FSHLanguageServer server;

    static final String HELP_PARAMETER = "--help";

    static final String HELP_MESSAGE =
            "`--help` to display this message\n\n"
                    + "When launching without parameter, the Language Client can use Standard Input and Ouput to connect to the FSH Language Server.\n\n";

    public static void main(String[] args) {
        List<String> arguments = Arrays.asList(args);
        if (arguments.contains(HELP_PARAMETER)) {
            System.out.println(HELP_MESSAGE);
        } else {
            System.out.println("server started.");

            server = new FSHLanguageServer();
            Launcher<LanguageClient> launcher = LSPLauncher.createServerLauncher(server, System.in, System.out);
            server.connect(launcher.getRemoteProxy());
            launcher.startListening();
        }
    }
}