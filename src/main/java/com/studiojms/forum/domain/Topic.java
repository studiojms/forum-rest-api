package com.studiojms.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime date = LocalDateTime.now();

	private String title;

	private String message;

	@ManyToOne
	private Course course;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private TopicStatus status = TopicStatus.NOT_ANSWERED;

}
