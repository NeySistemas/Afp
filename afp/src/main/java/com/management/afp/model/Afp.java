package com.management.afp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Afp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp = "^[\\p{L} .'-]+$",message = "NOmbre de Afp solo debe tener letras")
    @Column(nullable = false,length = 12)
    private String nombre;



}
