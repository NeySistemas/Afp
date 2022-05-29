package com.management.afp.service;

import com.management.afp.model.Solicitation;

import java.util.List;

public interface SolicitationService {
    List<Solicitation> findAll();
    Solicitation create(Solicitation solicitation);
    Solicitation findById(long id);
    Solicitation update(Solicitation solicitation);
    void delete(long id);
}
