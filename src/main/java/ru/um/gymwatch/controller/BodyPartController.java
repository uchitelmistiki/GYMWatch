package ru.um.gymwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.BodyPart;
import ru.um.gymwatch.service.BodyPartService;
import java.util.Optional;

@CrossOrigin
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
        if (!bodyPart.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bodyPart.get());
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(bodyPartService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BodyPart bodyPart, @PathVariable Integer id){
        Optional<BodyPart> bodyPartOptional = bodyPartService.findById(id);
        if (!bodyPartOptional.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bodyPartService.update(bodyPart, bodyPartOptional.get()));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        bodyPartService.delete(id);
    }
}
