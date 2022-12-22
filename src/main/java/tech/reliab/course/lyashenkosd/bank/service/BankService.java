package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;

/** Интерфейс операций, связанных с классом {@link Bank}
 * @version 0.1*/
public interface BankService {

    /** Процедура вывода всех данных по банку:
     * банкоматы, офисы, сотрудники, клиенты в консоль
     * @param id идентификатор банка*/
    void getAllInformation(Integer id);

    /** Функция возвращает экземпляр класса {@link Bank}
     * @param id идентификатор банка */
    Bank getBank(Integer id);

    /** Процедура создания объекта {@link Bank}
     * и добавление в список всех существующих банков
     * @param id идентификатор
     * @param name название банка*/
    void createBank(Integer id, String name);

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

    /** Удаление данных о банке. <br>
     * @param bank банк, экземпляр класса Bank, который требуется удалить
     * @return null
     */
    public Bank delete(Bank bank);
}
