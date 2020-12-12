package ru.um.gymwatch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.um.gymwatch.entity.BodyArea;

@Repository
public interface BodyAreaRepository extends JpaRepository<BodyArea,Integer> {
}
