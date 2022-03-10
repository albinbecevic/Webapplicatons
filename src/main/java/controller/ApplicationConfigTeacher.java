/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.faces.annotation.FacesConfig;

/**
 *
 * @author albinbecevic
 */

@DatabaseIdentityStoreDefinition(
    dataSourceLookup = "jdbc/schoolit_teacher",
    callerQuery = "select password from (select * from Teacher union select * from Student) as u where email = ?",
    groupsQuery = "select userType from (select * from Teacher union select * from Student) as v where email = ?"
)

@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(
                loginPage = "/index.xhtml",
                errorPage = "",
                useForwardToLogin = false
        )
)

@FacesConfig
@ApplicationScoped
public class ApplicationConfigTeacher {
    
}
