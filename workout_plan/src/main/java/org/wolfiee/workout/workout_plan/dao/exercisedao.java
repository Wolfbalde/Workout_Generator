package org.wolfiee.workout.workout_plan.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.wolfiee.workout.workout_plan.model.exercise;

import java.util.List;

@Repository
public interface exercisedao extends JpaRepository<exercise, Integer> {



    @Query(value = """
        SELECT * FROM (
            SELECT *, ROW_NUMBER() OVER (PARTITION BY musclegroup ORDER BY RANDOM()) as rn
            FROM exercise
        ) sub
        WHERE rn <= 2
        """, nativeQuery = true)
    List<exercise> generateworkout();
}
