package com.course.crudcourse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
