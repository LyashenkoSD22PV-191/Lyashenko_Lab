package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Employee;
import tech.reliab.course.lyashenkosd.bank.service.EmployeeService;

/** Класс-реализация операций сотрудника, реализует интерфейс сотрудника {@link EmployeeService} <br>
 * Реализуется бизнес-логика. Singleton*/
public class EmployeeServiceOperations implements EmployeeService {

    private EmployeeServiceOperations(){}

    public static final EmployeeService EMPLOYEE_SERVICE = new EmployeeServiceOperations();

    public void addSalary(Employee employee, Integer sum){
      employee.setSalary(employee.getSalary() + sum);
    }

}
