package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;
import tech.reliab.course.lyashenkosd.bank.service.BankOfficeService;

import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций банковского офиса, реализует интерфейс сервиса банковского офиса {@link BankOfficeService}
 * <br> Реализуется бизнес-логика. Singleton
 * */
public class BankOfficeServiceOperations implements BankOfficeService {
    private final Map<Integer, BankOffice> offices = new HashMap<>();

    /**
     * Закрытый конструктор, для реализации Singleton
     */
    private BankOfficeServiceOperations() {
    }

    public static final BankOfficeService BANK_OFFICE_SERVICE = new BankOfficeServiceOperations();

    @Override
    public void createOffice(Bank bank, Integer id, String name, String address, Boolean activityStatus,
                             Boolean mayToLocateAtmStatus, Integer atmQty, Boolean mayToCreditStatus,
                             Boolean cashOutStatus, Boolean cashInStatus, Integer moneyQtyInOffice, Integer rent) {
        bank.setOfficeQty(bank.getOfficeQty() + 1);
        offices.put(id, new BankOffice(id, bank.getId(), name, address, activityStatus, mayToLocateAtmStatus,
                atmQty, mayToCreditStatus, cashOutStatus, cashInStatus, moneyQtyInOffice, rent));

    }

    @Override
    public BankOffice getBankOffice(Integer id) {
        return offices.get(id);
    }

    public void addAtm(BankOffice bankOffice) {
        bankOffice.setAtmQty(bankOffice.getAtmQty() + 1);
    }
}
