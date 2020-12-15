package ru.um.gymwatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.um.gymwatch.entity.BodyArea;
import ru.um.gymwatch.service.BodyAreaService;

import java.util.Optional;

@RestController
@RequestMapping("/bodyareas")
public class BodyAreaController {
    private BodyAreaService bodyAreaService;

    @Autowired
    public BodyAreaController(BodyAreaService bodyAreaService) {
        this.bodyAreaService = bodyAreaService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody BodyArea bodyArea){
        return ResponseEntity.ok(bodyAreaService.save(bodyArea));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<BodyArea> bodyArea = bodyAreaService.findById(id);
        if (!bodyArea.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bodyArea.get());
    }

    @GetMapping
    public ResponseEntity findAll(){
        return ResponseEntity.ok(bodyAreaService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BodyArea bodyArea, @PathVariable Integer id){
        Optional<BodyArea> bodyAreaOptional = bodyAreaService.findById(id);
        if (!bodyAreaOptional.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bodyAreaService.update(bodyArea, bodyAreaOptional.get()));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        bodyAreaService.delete(id);
    }
}
