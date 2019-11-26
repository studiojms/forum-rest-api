package com.studiojms.forum.domain.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AuthenticationMethodEnum {
    BEARER("Bearer"),
    DIGEST("Digest"),
    BASIC("Basic");

    private String value;

}
