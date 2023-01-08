package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;

/** Интерфейс операций, связанных с классом {@link BankOffice}*/
public interface BankOfficeService {

    /**
     * Процедура создания экземпляра {@link BankOffice}
     */
    void createOffice(Bank bank, Integer id, String name, String address, Boolean activityStatus,
                      Boolean mayToLocateAtmStatus, Integer atmQty, Boolean mayToCreditStatus,
                      Boolean cashOutStatus, Boolean cashInStatus, Integer moneyQtyInOffice,
                      Integer rent);

    /**
     * Функция получения объекта {@link BankOffice}
     *
     * @param id идентификатор офиса
     * @return объект класса {@link BankOffice}
     */
    BankOffice getBankOffice(Integer id);


    /**
     * Процедура добавления банкомата. <br>
     * Добавляет плюс один к полю <b>atmQty</b>.
     *
     * @param bankOffice банковский офис, к которому следует добавить банкомат
     */
    void addAtm(BankOffice bankOffice);

}
