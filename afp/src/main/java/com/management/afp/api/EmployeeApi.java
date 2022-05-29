package com.management.afp.api;

import com.management.afp.exception.ModeloNotFoundException;
import com.management.afp.model.Employee;
import com.management.afp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "employees")
public class EmployeeApi {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee){
        Employee response = employeeService.create(employee);
        return new ResponseEntity<Employee>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@Valid @RequestBody Employee employee){
        Employee response = employeeService.update(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") long id){
        Employee employee = employeeService.findById(id);
        if(employee.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Employee employee = employeeService.findById(id);
        if(employee.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
