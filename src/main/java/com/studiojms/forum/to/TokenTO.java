package com.studiojms.forum.to;

import com.studiojms.forum.domain.security.AuthenticationMethodEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenTO {
    private String token;
    private AuthenticationMethodEnum authenticationMethod;
}
