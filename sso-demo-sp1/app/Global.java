/**
 * Copyright 2014 Milinda Pathirage
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.pac4j.core.client.Clients;
import org.pac4j.saml.client.Saml2Client;
import play.Application;
import play.GlobalSettings;
import org.pac4j.play.Config;
import play.Play;
import play.Logger;


public class Global extends GlobalSettings {
    @Override
    public void onStart(Application application) {
        Config.setErrorPage401(views.html.error401.render().toString());
        Config.setErrorPage403(views.html.error403.render().toString());

        final String baseUrl = "http://localhost:9000";

        final Saml2Client saml2Client = new Saml2Client();
        saml2Client.setKeystorePath("resource:sp1-keystore.jks");
        saml2Client.setKeystorePassword("pac4j-demo-passwd");
        saml2Client.setPrivateKeyPassword("pac4j-demo-passwd");
        saml2Client.setIdpMetadataPath("resource:idp.xml");


        final Clients clients = new Clients(baseUrl + "/callback", saml2Client);
        Config.setClients(clients);

        super.onStart(application);
    }
}
