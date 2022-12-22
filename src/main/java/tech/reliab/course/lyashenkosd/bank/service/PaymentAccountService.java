package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.entity.PaymentAccount;
import tech.reliab.course.lyashenkosd.bank.entity.User;

/** Интерфейс операций, связанных с классом {@link PaymentAccount}
 * @version 0.1 */
public interface PaymentAccountService {

    /** Процедура создания экземпляра {@link PaymentAccount} */
    void createPaymentAccount(Bank bank, User user, Integer id, Integer currentSum);

    /** Функция получения экземпляра {@link PaymentAccount}
     * @param id идентификатор платёжного счета
     * @return объект класса {@link PaymentAccount}*/
    PaymentAccount getPaymentAccount(Integer id);

    /** Процедура добавления денег на платежный счет
     * @param paymentAccount платежный счет, куда добавляются деньги
     * @param moneyQty количество денег, которое необходимо добавить */
    void addMoney(PaymentAccount paymentAccount, Integer moneyQty);

    /** Процедура вычитания денег из платежного счета
     * @param paymentAccount платежный счет, откуда вычитаются деньги
     * @param moneyQty сумма, которую необходимо вычесть */
    void subMoney(PaymentAccount paymentAccount,Integer moneyQty);

    /** Удаление данных о платежном счете
     * @param paymentAccount платежный счет, экземпляр класса PaymentAccount, который требуется удалить
     * @return null
     */
    public PaymentAccount delete(PaymentAccount paymentAccount);
}
