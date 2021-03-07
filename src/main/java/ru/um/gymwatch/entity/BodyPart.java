package ru.um.gymwatch.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "body_part")
@NoArgsConstructor
@AllArgsConstructor
public class BodyPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

}
