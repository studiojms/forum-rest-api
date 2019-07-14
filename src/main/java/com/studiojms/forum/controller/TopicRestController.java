package com.studiojms.forum.controller;

import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.service.TopicService;
import com.studiojms.forum.to.TopicTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicRestController {

    @Autowired
    private TopicService topicService;

    private final Logger LOGGER = LoggerFactory.getLogger(TopicRestController.class);

    @GetMapping
    public List<TopicTO> list(String course) {
        List<Topic> topics;
        if (course != null) {
            topics = topicService.findByCourseNameLike(course);
        } else {
            topics = topicService.list();
        }

        return TopicTO.create(topics);
    }

    @PostMapping
    public ResponseEntity<TopicTO> create(@RequestBody @Valid TopicTO topicTO, UriComponentsBuilder uriComponentsBuilder) {
        ResponseEntity response;

        try {
            Topic topic = topicService.create(topicTO);

            URI uri = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();

            response = ResponseEntity.created(uri).body(TopicTO.create(topic));
        } catch (Exception e) {
            LOGGER.error("An error occurred when creating a new topic");
            e.printStackTrace();

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicTO> findById(@PathVariable Long id) {
        ResponseEntity response;

        try {
            Topic topic = topicService.findById(id);
            response = ResponseEntity.ok(TopicTO.create(topic));
        } catch (Exception e) {
            response = ResponseEntity.noContent().build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicTO> update(@PathVariable Long id, @RequestBody @Valid TopicTO topicTO) {
        ResponseEntity response;

        try {
            Topic topic = topicService.update(id, topicTO);

            response = ResponseEntity.ok(TopicTO.create(topic));
        } catch (Exception e) {
            LOGGER.error("An error occurred when updating the topic " + id);
            e.printStackTrace();

            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response;

        try {
            topicService.delete(id);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

}

