package com.management.afp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float monto_disponible;
    private LocalDate fecha_retiro; //la fecha se debe colocar como "YYYY-MM-DD" desde Postman
    @Pattern(regexp = "^[0-9]*$",message = "Cuenta debe tener solo numeros")
    private String num_cuenta;
    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
