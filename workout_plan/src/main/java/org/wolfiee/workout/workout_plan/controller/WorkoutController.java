package org.wolfiee.workout.workout_plan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.wolfiee.workout.workout_plan.dto.workoutdto;
import org.wolfiee.workout.workout_plan.model.exercise;
import org.wolfiee.workout.workout_plan.service.workoutservice;

import java.util.List;

@RestController
public class WorkoutController {


    @Autowired
    workoutservice ws;


    @PostMapping("/workout")
    public ResponseEntity<String> createworkout(@RequestBody workoutdto workout){
        return ws.createworkout(workout);
    }


    @GetMapping("/workout/{title}")
    public ResponseEntity<List<exercise>> getworkout(@PathVariable String title){
        return ws.getworkout(title);
    }

}
