package com.management.afp.service;

import com.management.afp.model.Afp;

import java.util.List;

public interface AfpService {
    List<Afp> findAll();
    Afp create(Afp afp);
    Afp findById(long id);
    Afp update(Afp afp);
    void delete(long id);
}
