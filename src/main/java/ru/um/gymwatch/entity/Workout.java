package ru.um.gymwatch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "workouts")
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @Column(name = "num_of_approach")
    private Integer numOfApproach;

    @Column(name = "num_of_repeats")
    private Integer numOfRepeats;

    private Integer weight;

    @JsonFormat(pattern="dd.MM.yyyy")
    private Date date;

}
