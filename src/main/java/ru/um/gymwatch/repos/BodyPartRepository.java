package ru.um.gymwatch.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.um.gymwatch.entity.BodyPart;

@Repository
public interface BodyPartRepository extends JpaRepository<BodyPart,Integer> {
}
