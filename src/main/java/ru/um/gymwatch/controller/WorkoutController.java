package ru.um.gymwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.Course;
import ru.um.gymwatch.entity.Exercise;
import ru.um.gymwatch.entity.Workout;
import ru.um.gymwatch.service.CourseService;
import ru.um.gymwatch.service.ExerciseService;
import ru.um.gymwatch.service.WorkoutService;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private WorkoutService workoutService;
    private ExerciseService exerciseService;
    private CourseService courseService;

    @Autowired
    public WorkoutController(WorkoutService workoutService, ExerciseService exerciseService, CourseService courseService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Workout workout){


        Optional<Course> optionalCourse = courseService.findById(workout.getCourse().getId());
        if (!optionalCourse.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        workout.setCourse(optionalCourse.get());
        Optional<Exercise> optionalExercise = exerciseService.findById(workout.getExercise().getId());
        if (!optionalExercise.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        workout.setExercise(optionalExercise.get());
        return ResponseEntity.ok(workoutService.save(workout));

    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<Workout> workout = workoutService.findById(id);
        if (!workout.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(workout.get());
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(workoutService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Workout workout, @PathVariable Integer id){
        Optional<Workout> workoutOptional = workoutService.findById(id);
        if (!workoutOptional.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(workoutService.update(workout, workoutOptional.get()));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        workoutService.delete(id);
    }
}
