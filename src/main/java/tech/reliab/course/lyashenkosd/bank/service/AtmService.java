package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankAtm;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;

/** Интерфейс операций, связанных с классом {@link BankAtm}
 * @version 0.1*/
public interface AtmService {


    void createATM(Bank bank, BankOffice bankOffice, Integer id, String name, Integer employeeId,
                   Boolean cashOutStatus, Boolean cashInStatus, Integer moneyQtyInAtm,
                   Integer serviceCost, BankAtm.Status status);

    BankAtm getAtm(Integer id);

    /** Процедура добавления денег в банкомат. <br>
     * @param bankAtm банкомат, к которому следует добавить деньги
     * @param moneyQty количество денег, которое следует добавить*/
    void addMoney(BankAtm bankAtm, Integer moneyQty);


}
