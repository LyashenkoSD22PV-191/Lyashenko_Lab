package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;

/** Интерфейс операций, связанных с классом {@link BankOffice}
 * @version 0.1*/
public interface BankOfficeService {

    /** Процедура добавления банкомата. <br>
     * Добавляет плюс один к полю <b>atmQty</b>.
     * @param bankOffice банковский офис, к которому следует добавить банкомат*/
    void addAtm(BankOffice bankOffice);

}
