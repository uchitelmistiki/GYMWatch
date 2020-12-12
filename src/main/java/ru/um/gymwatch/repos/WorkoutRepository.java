package ru.um.gymwatch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.um.gymwatch.entity.Workout;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {
}
