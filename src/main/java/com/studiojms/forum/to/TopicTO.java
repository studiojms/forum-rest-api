package com.studiojms.forum.to;

import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.domain.TopicStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class TopicTO {

    private Long id;

    @NotNull
    private LocalDateTime date = LocalDateTime.now();

    @NotEmpty
    @Size(min = 5)
    private String title;

    @NotEmpty
    @Size(min = 20)
    private String message;

    @NotNull
    private UserTO user;

    @NotNull
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
