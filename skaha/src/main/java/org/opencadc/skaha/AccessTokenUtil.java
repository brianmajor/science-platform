package org.opencadc.skaha;

import ca.nrc.cadc.auth.AuthenticationUtil;
import ca.nrc.cadc.auth.AuthorizationToken;
import org.springframework.util.StringUtils;

import javax.security.auth.Subject;
import java.util.Set;

public class AccessTokenUtil {


    public AccessTokenUtil() {
    }

    public AuthorizationToken authorizationToken() {
        Subject subject = AuthenticationUtil.getCurrentSubject();
        Set<AuthorizationToken> authorizationTokenSet = subject.getPublicCredentials(AuthorizationToken.class);
        if (authorizationTokenSet.isEmpty()) {
            throw new UnsupportedOperationException("Authorization token credential is empty");
        }
        return authorizationTokenSet.iterator().next();
    }

    public String credential() {
        AuthorizationToken authorizationToken = authorizationToken();
        if (StringUtils.isEmpty(authorizationToken.getCredentials())) {
            throw new UnsupportedOperationException("access token can not be empty");
        }
        return authorizationToken.getCredentials();
    }
}
