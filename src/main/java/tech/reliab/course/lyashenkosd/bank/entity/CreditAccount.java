package tech.reliab.course.lyashenkosd.bank.entity;

import java.time.LocalDate;

/** Класс-модель кредитный счет со свойствами: <br> <b>{@link CreditAccount#id}</b>,
 * <br> <b>{@link CreditAccount#user}</b>, <br> <b>{@link CreditAccount#bank}</b>,
 * <br> <b>{@link CreditAccount#startCreditDate}</b>, <br> <b>{@link CreditAccount#finishCreditDate}</b>,
 * <br> <b>{@link CreditAccount#creditMonthQty}</b>, <br> <b>{@link CreditAccount#creditSum}</b>,
 * <br> <b>{@link CreditAccount#creditMonthPayment}</b>, <br> <b>{@link CreditAccount#percent}</b>,
 * <br> <b>{@link CreditAccount#employee}</b>, <br> <b>{@link CreditAccount#paymentAccount}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.CreditAccountService */
public class CreditAccount {

    /** Поле идентификатор кредитного счета. */
    private Integer id;

    /** Поле пользователь, за которым закреплен кредитный счет. <br>
     * @see User */
    private User user;

    /** Поле банка, где взять кредит. <br>
     * @see Bank */
    private Bank bank;

    /** Поле дата начала кредита */
    private LocalDate startCreditDate;

    /** Поле дата окончания кредита */
    private LocalDate finishCreditDate;

    /** Поле кол-во месяцев, на которые взят кредит */
    private Integer creditMonthQty;

    /** Поле сумма кредита */
    private Integer creditSum;

    /** Поле ежемесячный платеж */
    private Integer creditMonthPayment;

    /** Поле процентная ставка. <br>
     * Должна равняться кредитной ставке банка, в котором взять кредит. */
    private Float percent;

    /** Поле сотрудник, который выдал кредит
     * @see Employee */
    private Employee employee;

    /** Поле платежный счет в банке, с которого будет осуществляться погашение кредита. <br>
     * @see PaymentAccount */
    private PaymentAccount paymentAccount;

    /** Конструктор */
    public CreditAccount(Integer id, User user, Bank bank, Employee employee, PaymentAccount paymentAccount){
        setId(id);
        setUser(user);
        setBank(bank);
        setStartCreditDate(LocalDate.of(1, 1, 1));
        setFinishCreditDate(LocalDate.of(1,1,1));
        setCreditMonthQty(0);
        setCreditSum(0);
        setCreditMonthPayment(0);
        setPercent(bank.getPercent());
        setEmployee(employee);
        setPaymentAccount(paymentAccount);
    }

    /** Перегрузка функции toString()
     * для возвращения информации о кредитном счете в виде строки */
    @Override
    public String toString(){
        return "\nКредитный счёт{ " +
                "\nID кредитного счета: " + getId() +
                ",\nБанк счета: " + getBank().getName() +
                ",\nКредит выдал: " + getEmployee().getFullName() +
                ",\nID платежного счета: " + getId() +
                ",\nДата начала кредита: " + getStartCreditDate() +
                ",\nДата окончания кредита: " + getFinishCreditDate() +
                ",\nСумма кредита: " + getCreditSum() +
                ",\nПроцент: " + getPercent() +
                "\n}";
    }

    /** Функция получения значения поля {@link CreditAccount#id}
     * @return возвращает id номер кредитного счета */
    public Integer getId(){
        return this.id;
    }

    /** Функция получения значения поля {@link CreditAccount#user} <br>
     * См. также {@link User}
     * @return возвращает пользователя кредитного счета */
    public User getUser(){
        return this.user;
    }

    /** Функция получения значения поля {@link CreditAccount#bank} <br>
     * См. также {@link Bank}
     * @return возвращает банк кредитного счета, где взят кредит */
    public Bank getBank(){
        return this.bank;
    }

    /** Функция получения значения поля {@link CreditAccount#startCreditDate}
     * @return возвращает дату начала кредита */
    public LocalDate getStartCreditDate(){
        return this.startCreditDate;
    }

    /** Функция получения значения поля {@link CreditAccount#finishCreditDate}
     * @return возвращает дату окончания кредита */
    public LocalDate getFinishCreditDate(){
        return this.finishCreditDate;
    }

    /** Функция получения значения поля {@link CreditAccount#creditMonthQty}
     * @return возвращает количество месяцев кредита */
    public Integer getCreditMonthQty(){
        return this.creditMonthQty;
    }

    /** Функция получения значения поля {@link CreditAccount#creditSum}
     * @return возвращает сумму кредита */
    public Integer getCreditSum(){
        return this.creditSum;
    }

    /** Функция получения значения поля {@link CreditAccount#creditMonthPayment}
     * @return возвращает ежемесячный платеж */
    public Integer getCreditMonthPayment(){
        return this.creditMonthPayment;
    }

    /** Функция получения значения поля {@link CreditAccount#percent}
     * @return возвращает процентную ставку кредита */
    public Float getPercent(){
        return this.percent;
    }

    /** Функция получения значения поля {@link CreditAccount#employee}. <br>
     * См. также {@link Employee}
     * @return возвращает сотрудника, который выдал кредит */
    public Employee getEmployee(){
        return this.employee;
    }

    /** Функция получения значения поля {@link CreditAccount#paymentAccount} <br>
     * См. также {@link PaymentAccount}
     * @return возвращает платежный счет, с которого осуществляется погашение данного кредита */
    public PaymentAccount getPaymentAccount(){
        return this.paymentAccount;
    }

    /** Процедура определения идентификатора кредитного счета {@link CreditAccount#id}
     * @param id идентификатор кредитного счета */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Процедура определения пользователя кредитного счета {@link CreditAccount#user}. <br>
     * См. также {@link User}
     * @param user пользователь кредитного счета */
    public void setUser(User user) {
        this.user = user;
    }

    /** Процедура определения банка кредитного счета {@link CreditAccount#bank}. <br>
     * См. также {@link Bank}
     * @param bank банк кредитного счета, где был взят кредит */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /** Процедура определения даты начала кредита {@link CreditAccount#startCreditDate}
     * @param startCreditDate дата начала кредита */
    public void setStartCreditDate(LocalDate startCreditDate) {
        this.startCreditDate = startCreditDate;
    }

    /** Процедура определения даты окончания кредита {@link CreditAccount#finishCreditDate}
     * @param finishCreditDate дата окончания кредита */
    public void setFinishCreditDate(LocalDate finishCreditDate) {
        this.finishCreditDate = finishCreditDate;
    }

    /** Процедура определения количества месяцев кредита {@link CreditAccount#creditMonthQty}
     * @param creditMonthQty количество месяцев кредита */
    public void setCreditMonthQty(Integer creditMonthQty) {
        this.creditMonthQty = creditMonthQty;
    }

    /** Процедура определения суммы кредита {@link CreditAccount#creditSum}
     * @param creditSum сумма кредита */
    public void setCreditSum(Integer creditSum) {
        this.creditSum = creditSum;
    }

    /** Процедура определения ежемесячного платежа кредита {@link CreditAccount#creditMonthPayment}
     * @param creditMonthPayment сумма ежемесячного платежа кредита */
    public void setCreditMonthPayment(Integer creditMonthPayment) {
        this.creditMonthPayment = creditMonthPayment;
    }

    /** Процедура определения процентной ставки кредита {@link CreditAccount#paymentAccount}
     * @param percent процентной ставки кредита */
    public void setPercent(Float percent) {
        this.percent = percent;
    }

    /** Процедура определения сотрудника, который выдал кредит {@link CreditAccount#bank}. <br>
     * См. также {@link Employee}
     * @param employee сотрудник, который выдал кредит */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /** Процедура определения платежного счета {@link CreditAccount#paymentAccount}. <br>
     * См. также {@link PaymentAccount}
     * @param paymentAccount платежный счет, с которого осуществляется погашение кредита. */
    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
}
