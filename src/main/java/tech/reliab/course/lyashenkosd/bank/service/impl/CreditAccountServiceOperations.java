package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.*;
import tech.reliab.course.lyashenkosd.bank.service.CreditAccountService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций кредитного счета, реализует интерфейс сервис кредитного счета {@link CreditAccountService}.
 * <br> Реализуется бизнес-логика. Singleton */
public class CreditAccountServiceOperations implements CreditAccountService {
    private final Map<Integer, CreditAccount> creditAccounts = new HashMap<>();

    private CreditAccountServiceOperations(){}

    public static final CreditAccountService CREDIT_ACCOUNT_SERVICE = new CreditAccountServiceOperations();

    @Override
    public void createCreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                                    Integer id, LocalDate startCreditDate, LocalDate finishCreditDate,
                                    Integer creditMonthQty, Integer creditSum, Integer creditMonthPayment) {
        CreditAccount creditAccount = new CreditAccount(bank, user, employee, paymentAccount,
                id, startCreditDate, finishCreditDate, creditMonthQty, creditSum, creditMonthPayment);
        user.setCreditAccount(creditAccount);
        creditAccounts.put(id, creditAccount);
    }

    @Override
    public CreditAccount getCreditAccount(Integer id) {
        return creditAccounts.get(id);
    }

    public void subCreditSum(CreditAccount creditAccount, Integer sum){
        creditAccount.setCreditSum(creditAccount.getCreditSum() - sum);
    }

}
