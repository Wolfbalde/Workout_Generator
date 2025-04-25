package org.wolfiee.workout.workout_plan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wolfiee.workout.workout_plan.model.exercise;
import org.wolfiee.workout.workout_plan.service.exerciseservice;

import java.util.List;

@RestController
public class ExerciseController {



    @Autowired
    exerciseservice es;

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }



    @PostMapping("/exercise")
    public ResponseEntity<String> addexercise(@RequestBody List<exercise> exer){
        return es.addorupdateexercise(exer);
    }

    @PutMapping("/exercise")
    public ResponseEntity<String> updateexercise(@RequestBody List<exercise> exer){
        return es.addorupdateexercise(exer);
    }


    @GetMapping("/exercise")
    public ResponseEntity<List<exercise>> findallexercise(){
        return es.retrieveall();
    }


    @DeleteMapping("/exercise/{id}")
    public ResponseEntity<String> deleteexercise(@PathVariable Integer id){
        return es.deleteexercise(id);
    }
}
