package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.BankAtm;

/** Интерфейс операций, связанных с классом {@link BankAtm}
 * @version 0.1*/
public interface AtmService {

    /** Процедура добавления денег в банкомат. <br>
     * @param bankAtm банкомат, к которому следует добавить деньги
     * @param moneyQty количество денег, которое следует добавить*/
    void addMoney(BankAtm bankAtm, Integer moneyQty);


}
