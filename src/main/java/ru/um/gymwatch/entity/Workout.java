package ru.um.gymwatch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "workouts")
@NoArgsConstructor
@AllArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_course")
    @Getter
    @Setter
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_exercise")
    @Getter
    @Setter
    private Exercise exercise;

    @Getter
    @Setter
    @Column(name = "num_of_approach")
    private Integer numOfApproach;

    @Getter
    @Setter
    @Column(name = "num_of_repeats")
    private Integer numOfRepeats;

    @Getter
    @Setter
    private Integer weight;

    @Getter
    @Setter
    @JsonFormat(pattern="dd.MM.yyyy")
    private Date date;

}
