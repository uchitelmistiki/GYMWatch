package ru.um.gymwatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.entity.Course;
import ru.um.gymwatch.repos.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    
    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course){
        return courseRepository.save(course);
    }

    public Optional<Course> findById(int id){
        return courseRepository.findById(id);
    }

    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public void delete(int id){
        courseRepository.deleteById(id);
    }

    public Course update(Course currentCourse, Course courseToUpdate){
        courseToUpdate.setName(currentCourse.getName());
        courseToUpdate.setAuthor(currentCourse.getAuthor());
        courseToUpdate.setDuration(currentCourse.getDuration());
        return courseRepository.save(courseToUpdate);
    }
}
