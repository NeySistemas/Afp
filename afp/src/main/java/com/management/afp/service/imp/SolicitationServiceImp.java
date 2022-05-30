package com.management.afp.service.imp;

import com.management.afp.exception.ModeloBadRequestException;
import com.management.afp.model.Account;
import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.model.Solicitation;
import com.management.afp.repository.EmployeeRepository;
import com.management.afp.repository.SolicitationRepository;
import com.management.afp.service.AccountService;
import com.management.afp.service.EmployeeService;
import com.management.afp.service.SolicitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class SolicitationServiceImp implements SolicitationService {

    @Autowired
    SolicitationRepository solicitationRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AccountService accountService;

     @Override
    public List<Solicitation> findAll() {
        return solicitationRepository.findAll();
    }

    @Override
    public Solicitation create(String dni, float monto_retiro, String afp) {
        Employee employee = employeeService.findByDni(dni);
        Account account = accountService.findByIdEmployee(employee.getId());
        //En esta parte se hace la validacion de monto minimo. si no cumple con la regla bota la excepcion con su mensaje
        if(monto_retiro <= account.getMonto_disponible()/2){
            throw new ModeloBadRequestException("Monto mínimo no cubierto. Por favor revise el monto mínimo a retirar");
        }
        //En esta parte se hace la validacion de monto maximo. si no cumple la regla, bota la excepcion con su mensaje
        if(monto_retiro>account.getMonto_disponible()){
            throw new ModeloBadRequestException("No se puede registrar la solicitud. Monto mayor que el permitido");
        }

        Solicitation solicitation=new Solicitation();
        solicitation.setFecha_solicitud(LocalDate.now());
        solicitation.setMonto_solicitado(monto_retiro);
        solicitation.setEmployee(employee);
        return solicitationRepository.save(solicitation);
    }

    @Override
    public Solicitation findById(long id) {
        Optional<Solicitation> op = solicitationRepository.findById(id);
        return op.isPresent() ? op.get() : new Solicitation();
    }

    @Override
    public Solicitation update(Solicitation solicitation) {
        return solicitationRepository.save(solicitation);
    }

    @Override
    public void delete(long id) {
        solicitationRepository.deleteById(id);
    }
}
