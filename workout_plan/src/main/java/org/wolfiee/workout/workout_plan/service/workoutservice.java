package org.wolfiee.workout.workout_plan.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.wolfiee.workout.workout_plan.dao.exercisedao;
import org.wolfiee.workout.workout_plan.dao.workoutdao;
import org.wolfiee.workout.workout_plan.dto.workoutdto;
import org.wolfiee.workout.workout_plan.model.exercise;
import org.wolfiee.workout.workout_plan.model.workout;

import java.util.List;
import java.util.Optional;

@Service
public class workoutservice {



    @Autowired
    exercisedao ed;

    @Autowired
    workoutdao wd;
    public ResponseEntity<String> createworkout(workoutdto workout) {

        List<exercise> work =ed.generateworkout();

        workout working= new workout();
        working.setTitle(workout.getTitle());
        working.setExercise_id(work);
        wd.save(working);

        return new ResponseEntity<>("sucess", HttpStatus.OK);

    }

    public ResponseEntity<List<exercise>> getworkout(String title) {

        Optional<workout> workout= wd.findBytitle(title);
        List<exercise> exercises=workout.get().getExercise_id();
        return new ResponseEntity<>(exercises,HttpStatus.OK);
    }
}
