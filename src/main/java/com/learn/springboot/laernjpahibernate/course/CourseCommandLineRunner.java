package com.learn.springboot.laernjpahibernate.course;


import com.learn.springboot.laernjpahibernate.course.Course;
import com.learn.springboot.laernjpahibernate.course.jdbc.CourseJdbcRepository;
import com.learn.springboot.laernjpahibernate.course.jpa.CourseJpaRepository;
import com.learn.springboot.laernjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS jpa", "Seungwon"));
        repository.save(new Course(2, "Learn abc jpa", "Seungwon"));
        repository.save(new Course(3, "Learn bca jpa", "Seungwon"));

        repository.deleteById(2L);

        System.out.println(repository.findById(1L).toString());

        System.out.println(repository.findAll().size());

        System.out.println(repository.findByAuthor("Seungwon"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn"));

    }
}
