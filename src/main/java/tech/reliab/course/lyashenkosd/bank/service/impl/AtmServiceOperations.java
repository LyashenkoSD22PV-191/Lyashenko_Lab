package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.BankAtm;
import tech.reliab.course.lyashenkosd.bank.entity.BankOffice;
import tech.reliab.course.lyashenkosd.bank.service.AtmService;

import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операция с банкоматом, реализует интерфейс сервиса банкомата {@link AtmService}. <br>
 * Реализуется бизнес-логика. Singleton */
public class AtmServiceOperations implements AtmService {
    private final Map<Integer, BankAtm> atms = new HashMap<>();

    private AtmServiceOperations(){}

    public static final AtmService ATM_SERVICE = new AtmServiceOperations();

    @Override
    public void createATM(Bank bank, BankOffice bankOffice, Integer id, String name,
                          Integer employeeId, Boolean cashOutStatus, Boolean cashInStatus,
                          Integer moneyQtyInAtm, Integer serviceCost, BankAtm.Status status) {
        bank.setAtmQty(bank.getAtmQty() + 1);
        bankOffice.setAtmQty(bankOffice.getAtmQty() + 1);
        atms.put(id, new BankAtm(bank, bankOffice, id, name, employeeId, cashOutStatus, cashInStatus,
                                moneyQtyInAtm, serviceCost, status));
    }

    @Override
    public BankAtm getAtm(Integer id) {
        return atms.get(id);
    }

    public void addMoney(BankAtm bankAtm, Integer moneyQty){

        if (moneyQty > bankAtm.getBank().getMoneyQty()){
            System.out.println("Невозможно поместить в банкомат сумму превышающую кол-во всех денег в банке");
            return;
        }
        if (moneyQty < 0){
            System.out.println("Невозможно поместить в банкомат отрицательную сумму");
            return;
        }
        bankAtm.setMoneyQtyInAtm(bankAtm.getMoneyQtyInAtm() + moneyQty);
    }
}
