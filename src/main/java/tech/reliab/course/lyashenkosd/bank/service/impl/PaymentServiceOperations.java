package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.PaymentAccount;
import tech.reliab.course.lyashenkosd.bank.entity.User;
import tech.reliab.course.lyashenkosd.bank.service.PaymentAccountService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Класс-реализация операций платежного счета, реализует интерфейс платежного счета {@link PaymentAccountService} <br>
 * Реализуется бизнес-логика. <br> Singleton
 */
public class PaymentServiceOperations implements PaymentAccountService {
    private final Map<Integer, PaymentAccount> paymentAccounts = new HashMap<>();

    private PaymentServiceOperations() {
    }

    public static final PaymentAccountService PAYMENT_ACCOUNT_SERVICE = new PaymentServiceOperations();

    @Override
    public void createPaymentAccount(Bank bank, User user, Integer id, Integer currentSum) {
        boolean isUserAlreadyExist = false;
        for (int i = 1; i <= paymentAccounts.size(); i++) {
            if (Objects.equals(paymentAccounts.get(i).getUser().getId(), user.getId())) {
                isUserAlreadyExist = true;
            }
        }

        if (!isUserAlreadyExist) {
            bank.setClientQty(bank.getClientQty() + 1);
        }

        PaymentAccount paymentAccount = new PaymentAccount(bank, user, id, 0);
        user.setPaymentAccount(paymentAccount);
        paymentAccounts.put(id, paymentAccount);

    }

    @Override
    public PaymentAccount getPaymentAccount(Integer id) {
        return paymentAccounts.get(id);
    }

    public void addMoney(PaymentAccount paymentAccount, Integer moneyQty) {
        paymentAccount.setCurrentSum(paymentAccount.getCurrentSum() + moneyQty);
    }

    public void subMoney(PaymentAccount paymentAccount, Integer moneyQty) {
        if (moneyQty > paymentAccount.getCurrentSum()) {
            System.out.println("Недостаточно средств");
            return;
        }
        paymentAccount.setCurrentSum(paymentAccount.getCurrentSum() - moneyQty);
    }
}
