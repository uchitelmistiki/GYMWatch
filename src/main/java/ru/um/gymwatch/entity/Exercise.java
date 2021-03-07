package ru.um.gymwatch.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "exercises")
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_part")
    private BodyPart bodyPart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_area")
    private BodyArea bodyArea;

    @NotNull
    private String name;

}
