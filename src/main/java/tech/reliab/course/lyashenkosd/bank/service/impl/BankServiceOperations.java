package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.service.BankService;

/** Класс-реализация операций банка, реализует интерфейс банковского сервиса {@link BankService}. <br>
 * Реализуется бизнес-логика. Singleton*/
public class BankServiceOperations implements BankService {

    private BankServiceOperations(){}

    public static final BankService BANK_SERVICE = new BankServiceOperations();
    @Override
    public void addAtm(Bank bank) {
        bank.setAtmQty(bank.getAtmQty() + 1);
    }

    @Override
    public void addOffice(Bank bank) {
        bank.setOfficeQty(bank.getOfficeQty() + 1);
    }

    @Override
    public void addEmployee(Bank bank) {
        bank.setEmployeeQty(bank.getEmployeeQty() + 1);
    }

    @Override
    public void addClient(Bank bank) {
        bank.setClientQty(bank.getClientQty() + 1);
    }

}
