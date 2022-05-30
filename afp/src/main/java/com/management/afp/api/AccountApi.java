package com.management.afp.api;

import com.management.afp.exception.ModeloNotFoundException;
import com.management.afp.model.Account;
import com.management.afp.model.Afp;
import com.management.afp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountApi {

    @Autowired
    AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> findAll(){
        return ResponseEntity.ok(accountService.findAll());
    }

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody Account account){
        Account response = accountService.create(account);
        return new ResponseEntity<Account>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Account> update(@Valid @RequestBody Account account){
        Account response = accountService.update(account);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable("id") long id){
        Account account = accountService.findById(id);
        //El servicio genera un objeto con Id=0 si no encuentra en la base de datos. si es asi, se lanza la excepcion con su mensaje
        if(account.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Account account = accountService.findById(id);
        if(account.getId()==0)
            throw new ModeloNotFoundException("ID no encontrado");
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
