package com.management.afp.service;

import com.management.afp.model.Afp;
import com.management.afp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee create(Employee employee);
    Employee findById(long id);
    Employee findByDni(String dni);
    Employee update(Employee employee);
    void delete(long id);

}
