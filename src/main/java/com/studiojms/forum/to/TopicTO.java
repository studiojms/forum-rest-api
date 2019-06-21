package com.studiojms.forum.to;

import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.domain.TopicStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TopicTO {

    private Long id;
    private LocalDateTime date = LocalDateTime.now();
    private String title;
    private String message;
    private UserTO user;
    private CourseTO course;
    private TopicStatus status = TopicStatus.NOT_ANSWERED;

    public TopicTO(Topic topic) {
        this.id = topic.getId();
        this.date = topic.getDate();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.user = UserTO.create(topic.getUser());
        this.course = CourseTO.create(topic.getCourse());
        this.status = topic.getStatus();
    }

    public static TopicTO create(Topic topic) {
        return new TopicTO(topic);
    }

    public static List<TopicTO> create(List<Topic> topics) {
        return topics.stream().map(TopicTO::new).collect(Collectors.toList());
    }

}
