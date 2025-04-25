package org.wolfiee.workout.workout_plan.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wolfiee.workout.workout_plan.model.workout;

import java.util.Optional;

@Repository
public interface workoutdao extends JpaRepository<workout,Integer> {
    Optional<workout> findBytitle(String title);
}
