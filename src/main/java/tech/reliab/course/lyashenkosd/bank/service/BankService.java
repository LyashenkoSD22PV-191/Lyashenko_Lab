package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;

/** Интерфейс операций, связанных с классом {@link Bank}
 * @version 0.1*/
public interface BankService {

    /** Процедура добавления банкомата. <br>
     * Добавляет плюс один к полю <b>atmQty</b>.
     * @param bank банк, к которому следует добавить банкомат*/
    void addAtm(Bank bank);

    /** Процедура добавления офиса. <br>
     * Добавляется плюс один к полю <b>officeQty</b>.
     * @param bank банк, к которому следует добавить офис*/
    void addOffice(Bank bank);

    /** Процедура добавления сотрудника. <br>
     * Добавляется плюс один к полю <b>employeeQty</b>.
     * @param bank банк, к которому следует добавить сотрудника*/
    void addEmployee(Bank bank);

    /** Процедура добавления клиента. <br>
     * Добавляется плюс один к полю <b>clientQty</b>.
     * @param bank банк, к которому следует добавить клиента*/
    void addClient(Bank bank);

}
