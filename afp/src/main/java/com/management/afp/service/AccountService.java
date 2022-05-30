package com.management.afp.service;

import com.management.afp.model.Account;
import com.management.afp.model.Afp;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account create(Account account);
    Account findById(long id);
    Account update(Account account);
    void delete(long id);
    Account findByIdEmployee(long id);
}
