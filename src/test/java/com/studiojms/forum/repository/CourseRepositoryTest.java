package com.studiojms.forum.repository;

import com.studiojms.forum.domain.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CourseRepositoryTest {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private TestEntityManager entityManager;

    private void createCourse(String courseName) {
        final Course course = new Course();
        course.setName("Javascript");
        entityManager.persist(course);
    }

    @Test
    public void shouldLoadCourseWhenFindingByName() {
        String courseName = "Javascript";

        createCourse(courseName);

        final Course course = courseRepository.findByName(courseName);

        assertNotNull(course);
        assertEquals(courseName, course.getName());
    }

    @Test
    public void shouldNotLoadCourseWhenFindingByNameWithInvalidName() {
        String courseName = "JPA";

        final Course course = courseRepository.findByName(courseName);

        assertNull(course);
    }
}
