package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.*;

import java.time.LocalDate;

/** Интерфейс операций, связанных с классом {@link CreditAccount}
 * @version 0.1*/
public interface CreditAccountService {

    /** Процедура создания экземпляра {@link CreditAccount} */
    void createCreditAccount(Bank bank, User user, Employee employee, PaymentAccount paymentAccount,
                             Integer id, LocalDate startCreditDate, LocalDate finishCreditDate,
                             Integer creditMonthQty, Integer creditSum, Integer creditMonthPayment);

    /** Функция получения экземпляра {@link CreditAccount}
     * @param id идентификатор кредитного счета
     * @return объект класса {@link CreditAccount}*/
    CreditAccount getCreditAccount(Integer id);

    /** Процедура вычитания суммы из кредитного счета.
     * @param creditAccount кредитный счет, из которого необходимо вычесть сумму.
     * @param sum сумма, которую необходимо вычесть. */
    void subCreditSum(CreditAccount creditAccount, Integer sum);

    /** Удаление данных о кредитном счёте. <br>
     * @param creditAccount кредитный счёт, экземпляр класса CreditAccount, который требуется удалить
     * @return null
     */
    public CreditAccount delete(CreditAccount creditAccount);
}
