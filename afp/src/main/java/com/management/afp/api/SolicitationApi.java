package com.management.afp.api;

import com.management.afp.exception.ModeloBadRequestException;
import com.management.afp.exception.ModeloNotFoundException;
import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.model.Solicitation;
import com.management.afp.repository.EmployeeRepository;
import com.management.afp.service.EmployeeService;
import com.management.afp.service.SolicitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "solicitations")
public class SolicitationApi {

    @Autowired
    SolicitationService solicitationService;


    @GetMapping
    public ResponseEntity<List<Solicitation>> findAll(){
        return ResponseEntity.ok(solicitationService.findAll());
    }

    //El metodo create debe ser probado desde Postman con entradas como parametros
    @PostMapping
    public ResponseEntity<Solicitation> create(@RequestParam("dni") String dni, @RequestParam("monto_retiro") float monto_retiro, @RequestParam("afp") String afp){
        //Se hace una validacion segun las reglas del negocio establecidas en el paquete servicio y si genera excepcion, se atrapa y se bota una excepcion con su mensaje
        try {
            Solicitation response = solicitationService.create(dni,monto_retiro,afp);
            return new ResponseEntity<Solicitation>(response, HttpStatus.CREATED);
        } catch (ModeloBadRequestException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }

    }

    @PutMapping
    public ResponseEntity<Solicitation> update(@RequestBody Solicitation solicitation){
        Solicitation response = solicitationService.update(solicitation);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitation> findById(@PathVariable("id") long id){
        Solicitation solicitation = solicitationService.findById(id);
        //El servicio genera un objeto con Id=0 si no encuentra en la base de datos. si es asi, se lanza la excepcion con su mensaje
        if(solicitation.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        return ResponseEntity.ok(solicitation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Solicitation solicitation = solicitationService.findById(id);
        if(solicitation.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        solicitationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
