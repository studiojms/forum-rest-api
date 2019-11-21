package com.studiojms.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	private Subcategory subcategory;

}
