package com.management.afp.service.imp;

import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.repository.EmployeeRepository;
import com.management.afp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> op = employeeRepository.findById(id);
        return op.isPresent() ? op.get() : new Employee();

    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }
}
