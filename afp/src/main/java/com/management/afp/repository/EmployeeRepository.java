package com.management.afp.repository;

import com.management.afp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //El metodo que sigue sirve para encontrar al empleado en base a su DNI
    Employee findByDni(String dni);
}
