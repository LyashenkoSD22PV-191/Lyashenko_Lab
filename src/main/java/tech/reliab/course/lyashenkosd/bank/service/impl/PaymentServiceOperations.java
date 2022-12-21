package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.PaymentAccount;
import tech.reliab.course.lyashenkosd.bank.service.PaymentAccountService;

/** Класс-реализация операций платежного счета, реализует интерфейс платежного счета {@link PaymentAccountService} <br>
 * Реализуется бизнес-логика. Singleton*/
public class PaymentServiceOperations implements PaymentAccountService {

    private PaymentServiceOperations(){}

    public static final PaymentAccountService PAYMENT_ACCOUNT_SERVICE = new PaymentServiceOperations();

    public void addMoney(PaymentAccount paymentAccount, Integer moneyQty) {
        paymentAccount.setCurrentSum(paymentAccount.getCurrentSum() + moneyQty);
    }

    public void subMoney(PaymentAccount paymentAccount, Integer moneyQty) {
        if(moneyQty > paymentAccount.getCurrentSum()){
            System.out.println("Недостаточно средств");
            return;
        }
        paymentAccount.setCurrentSum(paymentAccount.getCurrentSum() - moneyQty);
    }
}
