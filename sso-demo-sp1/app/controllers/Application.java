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

package controllers;

import org.pac4j.core.profile.CommonProfile;
import org.pac4j.play.java.JavaController;
import org.pac4j.play.java.RequiresAuthentication;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends JavaController {

    @RequiresAuthentication(clientName = "Saml2Client")
    public static Result index() {
        CommonProfile userProfile = getUserProfile();
        return ok(index.render("Your new application is ready and your access token is: " + ((String)userProfile.getAttribute("access_token")).substring(0, 8) + "..."));
    }

}
