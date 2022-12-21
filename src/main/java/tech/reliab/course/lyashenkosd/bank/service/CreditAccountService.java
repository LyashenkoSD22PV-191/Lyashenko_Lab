package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.CreditAccount;

/** Интерфейс операций, связанных с классом {@link CreditAccount}
 * @version 0.1*/
public interface CreditAccountService {

    /** Процедура вычитания суммы из кредитного счета.
     * @param creditAccount кредитный счет, из которого необходимо вычесть сумму.
     * @param sum сумма, которую необходимо вычесть. */
    void subCreditSum(CreditAccount creditAccount, Integer sum);

}
