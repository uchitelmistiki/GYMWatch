package ru.um.gymwatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.um.gymwatch.entity.BodyArea;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.repos.BodyAreaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BodyAreaService {
    private BodyAreaRepository bodyAreaRepository;

    @Autowired
    public BodyAreaService(BodyAreaRepository bodyAreaRepository) {
        this.bodyAreaRepository = bodyAreaRepository;
    }

    public BodyArea save(BodyArea bodyArea){
        return bodyAreaRepository.save(bodyArea);
    }

    public Optional<BodyArea> findById(int id){
        return bodyAreaRepository.findById(id);
    }

    public List<BodyArea> findAll(){
        return bodyAreaRepository.findAll();
    }

    public void delete(int id){
        bodyAreaRepository.deleteById(id);
    }

    public BodyArea update(BodyArea currentBodyArea, BodyArea bodyAreaToUpdate){
        bodyAreaToUpdate.setName(currentBodyArea.getName());
        return bodyAreaRepository.save(bodyAreaToUpdate);
    }
}
