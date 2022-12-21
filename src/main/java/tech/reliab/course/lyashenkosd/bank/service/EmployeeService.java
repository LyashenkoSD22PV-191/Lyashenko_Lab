package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;
import tech.reliab.course.lyashenkosd.bank.entity.Employee;

import java.time.LocalDate;

/** Интерфейс операций, связанных с классом {@link Employee}
 * @version 0.1 */
public interface EmployeeService {

    /** Процедура создания экземпляра {@link Employee} */
    void createEmployee(Integer id, String fullName, LocalDate birthDate, String post, Bank bank,
                        Boolean onlineOrNot, BankOffice bankOffice, Boolean mayToGiveCredit,
                        Integer salary);

    /** Функция получения экземпляра {@link Employee}
     * @return экземпляр {@link Employee} сотрудника*/
    Employee getEmployee(Integer id);

    /** Процедура добавления зарплаты сотруднику.
     * @param employee сотрудник, которому добавляется зарплата
     * @param salary сумма, которую необходимо добавить к зарплате */
    void addSalary(Employee employee, Integer salary);

}
