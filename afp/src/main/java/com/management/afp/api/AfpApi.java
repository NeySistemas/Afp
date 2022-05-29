package com.management.afp.api;

import com.management.afp.exception.ModeloNotFoundException;
import com.management.afp.model.Afp;
import com.management.afp.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "afps")
public class AfpApi {
    @Autowired
    AfpService afpService;

    @GetMapping
    public ResponseEntity<List<Afp>> findAll(){
        return ResponseEntity.ok(afpService.findAll());
    }

    @PostMapping
    public ResponseEntity<Afp> create(@Valid @RequestBody Afp afp){
        Afp response = afpService.create(afp);
        return new ResponseEntity<Afp>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Afp> update(@Valid @RequestBody Afp afp){
        Afp response = afpService.update(afp);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Afp> findById(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);
        if(afp.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        return ResponseEntity.ok(afp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);
        if(afp.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        afpService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
