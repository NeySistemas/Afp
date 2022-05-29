package com.management.afp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Pattern(regexp = "^[\\p{L} .'-]+$",message = "Nombre solo debe tener letras")
    @Size(min = 3,message = "Nombre debe tener como minimo 3 caracteres")
    @Column(nullable = false,length = 70)
    private String nombres;
    @Pattern(regexp = "^[\\p{L} .'-]+$",message = "Apellido solo debe tener letras")
    @Column(nullable = false,length = 70)
    private String apellidos;
    @Pattern(regexp = "^[0-9]*$",message = "DNI debe tener solo numeros")
    @Size(min = 8,max = 8,message = "DNI debe tener 8 digitos")
    @Column(nullable = false,unique = true)
    private String dni;
    @Column(nullable = false,length = 9)
    private String telefono;
    @Column(nullable = false,length = 100)
    private String correo;
    @ManyToOne
    @JoinColumn(name = "id_afp")
    private Afp afp;
}
