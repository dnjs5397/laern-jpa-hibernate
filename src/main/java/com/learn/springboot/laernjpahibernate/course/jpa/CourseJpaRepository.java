package com.learn.springboot.laernjpahibernate.course.jpa;

import com.learn.springboot.laernjpahibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
//    @Autowired
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
}
