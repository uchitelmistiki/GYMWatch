package ru.um.gymwatch.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.Course;
import ru.um.gymwatch.service.CourseService;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Course course){
        return ResponseEntity.ok(courseService.save(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<Course> course = courseService.findById(id);
        if (!course.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(course.get());
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Course course, @PathVariable Integer id){
        Optional<Course> courseOptional = courseService.findById(id);
        if (!courseOptional.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(courseService.update(course, courseOptional.get()));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        courseService.delete(id);
    }
}
