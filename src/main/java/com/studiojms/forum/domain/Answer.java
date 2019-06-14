package com.studiojms.forum.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Answer {
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private String message;
    private Boolean isSolution = false;
    private Topic topic;
    private User owner;

}
