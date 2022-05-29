package com.management.afp;

import com.management.afp.model.Account;
import com.management.afp.model.Afp;
import com.management.afp.model.Employee;
import com.management.afp.service.AccountService;
import com.management.afp.service.AfpService;
import com.management.afp.service.EmployeeService;
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


	@Test
	void contextLoads() {
		afp.setId(1);
		//employee.setId(23);
		employee.setId(2);
		account.setId(1);
		account.setMonto_disponible(200);
		account.setFecha_retiro(LocalDate.of(2022,12,10));
		account.setEmployee(employee);
		accountService.update(account);
		//System.out.println(accountService.findById(1).getNum_cuenta());
	}

}
