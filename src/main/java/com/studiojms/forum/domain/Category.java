package com.studiojms.forum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private Long id;
    private String name;
    private List<Subcategory> subcategories = new ArrayList<>();

}
