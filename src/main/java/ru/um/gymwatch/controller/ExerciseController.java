package ru.um.gymwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.BodyArea;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.entity.Exercise;
import ru.um.gymwatch.service.BodyAreaService;
import ru.um.gymwatch.service.BodyPartService;
import ru.um.gymwatch.service.ExerciseService;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private ExerciseService exerciseService;
    private BodyPartService bodyPartService;
    private BodyAreaService bodyAreaService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, BodyPartService bodyPartService, BodyAreaService bodyAreaService) {
        this.exerciseService = exerciseService;
        this.bodyPartService = bodyPartService;
        this.bodyAreaService = bodyAreaService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Exercise exercise){
        Optional<BodyPart> optionalBodyPart = bodyPartService.findById(exercise.getBodyPart().getId());
        if (!optionalBodyPart.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        exercise.setBodyPart(optionalBodyPart.get());
        Optional<BodyArea> optionalBodyArea = bodyAreaService.findById(exercise.getBodyArea().getId());
        if (!optionalBodyArea.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        exercise.setBodyArea(optionalBodyArea.get());
        return ResponseEntity.ok(exerciseService.save(exercise));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<Exercise> exercise = exerciseService.findById(id);
        if (!exercise.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(exercise.get());
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(exerciseService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody Exercise exercise, @PathVariable Integer id){
        Optional<Exercise> exerciseOptional = exerciseService.findById(id);
        if (!exerciseOptional.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(exerciseService.update(exercise, exerciseOptional.get()));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        exerciseService.delete(id);
    }
}
