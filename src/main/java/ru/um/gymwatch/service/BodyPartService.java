package ru.um.gymwatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.um.gymwatch.entity.BodyArea;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.repos.BodyPartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BodyPartService {

    private BodyPartRepository bodyPartRepository;

    @Autowired
    public BodyPartService(BodyPartRepository bodyPartRepository) {
        this.bodyPartRepository = bodyPartRepository;
    }

    public BodyPart save(BodyPart bodyPart){
        return bodyPartRepository.save(bodyPart);
    }

    public Optional<BodyPart> findById(int id){
        return bodyPartRepository.findById(id);
    }

    public List<BodyPart> findAll(){
        return bodyPartRepository.findAll();
    }

    public void delete(BodyPart bodyPart){
        bodyPartRepository.delete(bodyPart);
    }

    public BodyPart update(BodyPart currentBodyPart){
        BodyPart bodyPartToUpdate = bodyPartRepository.getOne(currentBodyPart.getId());
        bodyPartToUpdate.setName(currentBodyPart.getName());
        return bodyPartRepository.save(bodyPartToUpdate);
    }
}
