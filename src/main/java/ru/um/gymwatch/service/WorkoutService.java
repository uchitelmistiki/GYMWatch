package ru.um.gymwatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.um.gymwatch.entity.Course;
import ru.um.gymwatch.entity.Workout;
import ru.um.gymwatch.repos.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    
    private WorkoutRepository workoutRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout save(Workout workout){
        return workoutRepository.save(workout);
    }

    public Optional<Workout> findById(int id){
        return workoutRepository.findById(id);
    }

    public List<Workout> findAll(){
        return workoutRepository.findAll();
    }

    public void delete(Workout workout){
        workoutRepository.delete(workout);
    }

    public Workout update(Workout currentWorkout){
        Workout workoutToUpdate = workoutRepository.getOne(currentWorkout.getId());
        workoutToUpdate.setNumOfApproach(currentWorkout.getNumOfApproach());
        workoutToUpdate.setNumOfRepeats(currentWorkout.getNumOfRepeats());
        workoutToUpdate.setDate(currentWorkout.getDate());
        workoutToUpdate.setWeight(currentWorkout.getWeight());
        return workoutRepository.save(workoutToUpdate);
    }
}
