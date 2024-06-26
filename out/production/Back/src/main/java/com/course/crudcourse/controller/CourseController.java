package com.course.crudcourse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.crudcourse.model.Course;
import com.course.crudcourse.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    @GetMapping
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @GetMapping

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public ResponseEntity<Course> create(@RequestBody Course course){
        System.out.println(course);
        return courseRepository.save(course);
        //return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntetity<Void> delete(@PathVariable Long id){
        return courseRepository.findById(id)
        .map(recordFound -> {
            courseRepository.deleteById(id);
            return ResponseEntity.noContet().<Void>build();
        }.orElse(ResponseEntity.notFound().build()));
    }
}
