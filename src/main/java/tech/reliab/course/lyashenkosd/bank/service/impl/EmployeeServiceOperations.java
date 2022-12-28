package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;
import tech.reliab.course.lyashenkosd.bank.entity.CreditAccount;
import tech.reliab.course.lyashenkosd.bank.entity.Employee;
import tech.reliab.course.lyashenkosd.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций сотрудника, реализует интерфейс сотрудника {@link EmployeeService} <br>
 * Реализуется бизнес-логика. Singleton*/
public class EmployeeServiceOperations implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    private EmployeeServiceOperations(){}

    public static final EmployeeService EMPLOYEE_SERVICE = new EmployeeServiceOperations();

    @Override
    public void createEmployee(Integer id, String fullName, LocalDate birthDate, String post,
                               Bank bank, Boolean onlineOrNot, BankOffice bankOffice,
                               Boolean mayToGiveCredit, Integer salary) {
        bank.setEmployeeQty(bank.getEmployeeQty() + 1);
        employees.add(new Employee(id, fullName, birthDate, post,
                        bank, onlineOrNot, bankOffice, mayToGiveCredit, salary));
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employees.get(id);
    }

    public void addSalary(Employee employee, Integer sum){
      employee.setSalary(employee.getSalary() + sum);
    }

    @Override
    public Employee delete(Employee employee){
        employee = null;
        return employee;
    }
}
