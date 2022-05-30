package com.management.afp.repository;

import com.management.afp.model.Account;
import com.management.afp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    //El metodo que sigue es en JPQL para la obtencion de un objeto Account en base a su id_employee asociado
    @Query(value = "select a from Account a where a.employee.id=:id")
    Account findByIdEmployee(long id);


}
