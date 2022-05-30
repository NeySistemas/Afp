package com.management.afp;

import com.management.afp.exception.ModeloBadRequestException;
import com.management.afp.model.Account;
import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.repository.AccountRepository;
import com.management.afp.repository.EmployeeRepository;
import com.management.afp.repository.SolicitationRepository;
import com.management.afp.service.AccountService;
import com.management.afp.service.AfpService;
import com.management.afp.service.EmployeeService;
import com.management.afp.service.SolicitationService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class AfpApplicationTests {
	Afp afp = new Afp();
	Account account = new Account();
	Employee employee = new Employee();
	@Autowired
	AfpService afpService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	AccountService accountService;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	SolicitationRepository solicitationRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SolicitationService solicitationService;

	@Test
	void contextLoads() {



	}

}
