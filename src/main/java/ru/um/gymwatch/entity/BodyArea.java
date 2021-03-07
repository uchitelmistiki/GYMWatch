package ru.um.gymwatch.entity;


import javax.validation.constraints.NotNull;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "body_area")
@NoArgsConstructor
@AllArgsConstructor
public class BodyArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
}
