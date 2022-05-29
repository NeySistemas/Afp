package com.management.afp.service.imp;

import com.management.afp.model.Afp;
import com.management.afp.repository.AfpRepository;
import com.management.afp.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfpServiceImp implements AfpService {

    @Autowired
    AfpRepository afpRepository;

    @Override
    public List<Afp> findAll() {
        return afpRepository.findAll();
    }

    @Override
    public Afp create(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public Afp findById(long id) {
        Optional<Afp> op = afpRepository.findById(id);
        return op.isPresent() ? op.get() : new Afp();
    }

    @Override
    public Afp update(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public void delete(long id) {
        afpRepository.deleteById(id);
    }
}
