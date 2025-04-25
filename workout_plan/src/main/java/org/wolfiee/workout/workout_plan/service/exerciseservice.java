package org.wolfiee.workout.workout_plan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wolfiee.workout.workout_plan.dao.exercisedao;
import org.wolfiee.workout.workout_plan.model.exercise;

import java.util.List;

@Service
public class exerciseservice {

    @Autowired
    exercisedao ed;

    public ResponseEntity<String> addorupdateexercise(List<exercise> exer) {

        try{
            ed.saveAll(exer);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<exercise>> retrieveall() {
        try{

            return new ResponseEntity<>(ed.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteexercise(Integer id) {

        try{
            ed.deleteById(id);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
