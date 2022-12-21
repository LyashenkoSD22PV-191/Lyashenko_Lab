package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;
import tech.reliab.course.lyashenkosd.bank.service.BankOfficeService;

/** Класс-реализация операций банковского офиса, реализует интерфейс сервиса банковского офиса {@link BankOfficeService}
 * <br> Реализуется бизнес-логика. Singleton*/
public class BankOfficeServiceOperations implements BankOfficeService {

    private BankOfficeServiceOperations(){}

    public static final BankOfficeService BANK_OFFICE_SERVICE= new BankOfficeServiceOperations();

    public void addAtm(BankOffice bankOffice) {
        bankOffice.setAtmQty(bankOffice.getAtmQty() + 1);
    }
}
