package com.studiojms.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    private Long id;
    private String name;
    private Subcategory subcategory;

}
