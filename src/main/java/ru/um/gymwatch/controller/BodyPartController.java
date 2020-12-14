package ru.um.gymwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.service.BodyPartService;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/bodyparts")
public class BodyPartController {

    private BodyPartService bodyPartService;

    @Autowired
    public BodyPartController(BodyPartService bodyPartService) {
        this.bodyPartService = bodyPartService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BodyPart bodyPart){
       return ResponseEntity.ok(bodyPartService.save(bodyPart));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<BodyPart> bodyPart = bodyPartService.findById(id);
        return Objects.isNull(bodyPart)
                ?ResponseEntity.notFound().build()
                :ResponseEntity.ok(bodyPart);
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(bodyPartService.findAll());
    }

    /*

    public void delete(BodyPart bodyPart){
        bodyPartRepository.delete(bodyPart);
    }

    public BodyPart update(BodyPart currentBodyPart){
        BodyPart bodyPartToUpdate = bodyPartRepository.getOne(currentBodyPart.getId());
        bodyPartToUpdate.setName(currentBodyPart.getName());
        return bodyPartRepository.save(bodyPartToUpdate);
    }
     */
}
