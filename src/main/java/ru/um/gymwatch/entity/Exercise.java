package ru.um.gymwatch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_part")
    @Getter
    @Setter
    private BodyPart bodyPart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_area")
    @Getter
    @Setter
    private BodyArea bodyArea;

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "exercise")
    private Set<Workout> workouts;

}
