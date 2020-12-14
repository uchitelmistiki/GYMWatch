package ru.um.gymwatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.um.gymwatch.entity.Course;
import ru.um.gymwatch.entity.Exercise;
import ru.um.gymwatch.repos.ExerciseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise save(Exercise exercise){
        return exerciseRepository.save(exercise);
    }

    public Optional<Exercise> findById(int id){
        return exerciseRepository.findById(id);
    }

    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }

    public void delete(Exercise exercise){
        exerciseRepository.delete(exercise);
    }

    public Exercise update(Exercise currentExercise){
        Exercise exerciseToUpdate = exerciseRepository.getOne(currentExercise.getId());
        exerciseToUpdate.setName(currentExercise.getName());
        return exerciseRepository.save(exerciseToUpdate);
    }
}
