package ru.um.gymwatch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.um.gymwatch.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
