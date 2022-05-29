package com.management.afp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Solicitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate fecha_solicitud;
    private float monto_solicitado;
    @OneToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
