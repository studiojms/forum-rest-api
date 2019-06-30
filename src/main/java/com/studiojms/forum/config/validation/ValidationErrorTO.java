package com.studiojms.forum.config.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ValidationErrorTO {
    @Getter
    private String field;

    @Getter
    private String message;
}
