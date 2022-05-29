package com.management.afp.api;

import com.management.afp.exception.ModeloNotFoundException;
import com.management.afp.model.Afp;
import com.management.afp.model.Solicitation;
import com.management.afp.service.SolicitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Solicitation> create(@RequestBody Solicitation solicitation){
        Solicitation response = solicitationService.create(solicitation);
        return new ResponseEntity<Solicitation>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Solicitation> update(@RequestBody Solicitation solicitation){
        Solicitation response = solicitationService.update(solicitation);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitation> findById(@PathVariable("id") long id){
        Solicitation solicitation = solicitationService.findById(id);
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
