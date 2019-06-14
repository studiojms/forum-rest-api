package com.studiojms.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Topic {
    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private String title;
    private String message;
    private Course course;
    private User owner;
    private List<Answer> answers = new ArrayList<>();
    private TopicStatus status = TopicStatus.NOT_ANSWERED;

}
