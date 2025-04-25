package org.wolfiee.workout.workout_plan.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;


import java.util.List;

@Data
@Entity

public class workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @ManyToMany
    private List<exercise> exercise_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<exercise> getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(List<exercise> exercise_id) {
        this.exercise_id = exercise_id;
    }
}
