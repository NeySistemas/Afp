package com.management.afp.service.imp;

import com.management.afp.model.Account;
import com.management.afp.model.Afp;
import com.management.afp.repository.AccountRepository;
import com.management.afp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(long id) {
        Optional<Account> op = accountRepository.findById(id);
        return op.isPresent() ? op.get() : new Account();
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(long id) {
        accountRepository.deleteById(id);
    }
}
