package com.management.afp.service.imp;

import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.model.Solicitation;
import com.management.afp.repository.SolicitationRepository;
import com.management.afp.service.EmployeeService;
import com.management.afp.service.SolicitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SolicitationServiceImp implements SolicitationService {

    @Autowired
    SolicitationRepository solicitationRepository;
    @Autowired
    EmployeeService employeeService;

    @Override
    public List<Solicitation> findAll() {
        return solicitationRepository.findAll();
    }

    @Override
    public Solicitation create(Solicitation solicitation) {

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
