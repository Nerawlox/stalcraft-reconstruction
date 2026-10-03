/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.eclipse.jetty.security.Authenticator
 *  org.eclipse.jetty.security.ConstraintMapping
 *  org.eclipse.jetty.security.ConstraintSecurityHandler
 *  org.eclipse.jetty.security.HashLoginService
 *  org.eclipse.jetty.security.LoginService
 *  org.eclipse.jetty.security.SecurityHandler
 *  org.eclipse.jetty.security.UserStore
 *  org.eclipse.jetty.security.authentication.BasicAuthenticator
 *  org.eclipse.jetty.util.security.Constraint
 *  org.eclipse.jetty.util.security.Credential
 */
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.ConstraintMapping;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.security.LoginService;
import org.eclipse.jetty.security.SecurityHandler;
import org.eclipse.jetty.security.UserStore;
import org.eclipse.jetty.security.authentication.BasicAuthenticator;
import org.eclipse.jetty.util.security.Constraint;
import org.eclipse.jetty.util.security.Credential;

public class eztn {
    public static SecurityHandler _a(String string, String string2) {
        HashLoginService hashLoginService = new HashLoginService();
        UserStore userStore = new UserStore();
        userStore.addUser(string, Credential.getCredential((String)string2), new String[]{"user"});
        hashLoginService.setUserStore(userStore);
        hashLoginService.setName("metrics");
        Constraint constraint = new Constraint();
        constraint.setName("BASIC");
        constraint.setRoles(new String[]{"user"});
        constraint.setAuthenticate(true);
        ConstraintMapping constraintMapping = new ConstraintMapping();
        constraintMapping.setConstraint(constraint);
        constraintMapping.setPathSpec("/*");
        ConstraintSecurityHandler constraintSecurityHandler = new ConstraintSecurityHandler();
        constraintSecurityHandler.setAuthenticator((Authenticator)new BasicAuthenticator());
        constraintSecurityHandler.setRealmName("metrics");
        constraintSecurityHandler.addConstraintMapping(constraintMapping);
        constraintSecurityHandler.setLoginService((LoginService)hashLoginService);
        return constraintSecurityHandler;
    }
}

