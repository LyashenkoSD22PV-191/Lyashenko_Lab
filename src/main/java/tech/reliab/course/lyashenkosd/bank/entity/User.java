package tech.reliab.course.lyashenkosd.bank.entity;

import java.time.LocalDate;
import java.util.Random;

/** Класс-модель пользователя со свойствами: <br> <b>{@link User#id}</b>,
 * <br> <b>{@link User#fullName}</b>, <br> <b>{@link User#birthDate}</b>,
 * <br> <b>{@link User#workPlace}</b>, <br> <b>{@link User#monthIncome}</b>,
 * <br> <b>{@link User#bank}</b>, <br> <b>{@link User#creditAccount}</b>,
 * <br> <b>{@link User#paymentAccount}</b>,<br> <b>{@link User#creditRate}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.UserService */
public class User {

    /** Поле идентификатор пользователя */
    private Integer id;

    /** Поле полное имя (ФИО) пользователя */
    private String fullName;

    /** Поле дата рождения пользователя */
    private LocalDate birthDate;

    /** Поле место работы */
    private String workPlace;

    /** Поле месячный доход */
    private Integer monthIncome;

    /** Поле банк, в котором числится клиент
     * @see Bank*/
    private Bank bank;

    /** Поле кредитный счет клиента
     * @see CreditAccount */
    private CreditAccount creditAccount;

    /** Поле платежный счет клиента
     * @see PaymentAccount */
    private PaymentAccount paymentAccount;

    /** Поле кредитный рейтинг клиента. <br>
     * Напрямую зависит от {@link User#monthIncome}, чем больше доход,
     * тем выше рейтинг*/
    private Integer creditRate;

    /** Конструктор */
    public User(Integer id, String fullName, LocalDate birthDate, String workPlace ,Bank bank){
        setId(id);
        setFullName(fullName);
        setBirthDate(birthDate);
        setWorkPlace(workPlace);
        Random random = new Random();
        setMonthIncome(random.nextInt(10001));
        setBank(bank);
        setCreditAccount(null);
        setPaymentAccount(null);
        setCreditRate(calculateCreditRate(this.monthIncome));
    }

    /** Вспомогательная функция для подсчета кредитного рейтинга клиента.
     * @see User#creditRate */
    private Integer calculateCreditRate(Integer monthIncome){
        if (monthIncome < 1000) {return 100;}
        if (monthIncome >= 1000 && monthIncome < 2000) {return 200;}
        if (monthIncome >= 2000 && monthIncome < 3000) {return 300;}
        if (monthIncome >= 3000 && monthIncome < 4000) {return 400;}
        if (monthIncome >= 4000 && monthIncome < 5000) {return 500;}
        if (monthIncome >= 5000 && monthIncome < 6000) {return 600;}
        if (monthIncome >= 6000 && monthIncome < 7000) {return 700;}
        if (monthIncome >= 7000 && monthIncome < 8000) {return 800;}
        if (monthIncome >= 8000 && monthIncome < 9000) {return 900;}
        return 1000;
    }

    /** Перегрузка функции toString()
     * для возвращения информации о пользователе в виде строки */
    @Override
    public String toString(){
        String string = "\nПользователь{" +
                "\nФИО: " + getFullName() +
                ",\nДата рождения: " + getBirthDate() +
                ",\nМесто работы: " + getWorkPlace() +
                ",\nБанк: " + getBank().getName() +
                ",\nМесячный доход: " + getMonthIncome() +
                ",\nКредитный рейтинг: " + getCreditRate();

        if (getPaymentAccount() == null) {string += ",\nПлатежный счет: отсутствует";}
        else{string += ",\nПлатежный счет: " + getPaymentAccount().getId();}

        if (getCreditAccount() == null){string += ",\nКредитный счет: отсутствует";}
        else{string += ",\nКредитный счет: " + getCreditAccount().getId();}

        string += "\n}";
        return string;

    }

    /** Функция получения значения поля {@link User#id}
     * @return возвращает id номер клиента */
    public Integer getId() {
        return this.id;
    }

    /** Функция получения значения поля {@link User#fullName}
     * @return возвращает ФИО клиента */
    public String getFullName() {
        return this.fullName;
    }

    /** Функция получения значения поля {@link User#birthDate}
     * @return возвращает дату рождения клиента */
    public LocalDate getBirthDate() {
        return this.birthDate;
    }


    /** Функция получения значения поля {@link User#workPlace}
     * @return возвращает место работы клиента */
    public String getWorkPlace() {
        return this.workPlace;
    }

    /** Функция получения значения поля {@link User#monthIncome}
     * @return возвращает месячный доход клиента */
    public Integer getMonthIncome() {
        return this.monthIncome;
    }

    /** Функция получения значения поля {@link User#bank}
     * @return возвращает банк клиента */
    public Bank getBank() {
        return this.bank;
    }

    /** Функция получения значения поля {@link User#creditAccount}
     * @return возвращает кредитный счет клиента */
    public CreditAccount getCreditAccount() {
        return this.creditAccount;
    }

    /** Функция получения значения поля {@link User#paymentAccount}
     * @return возвращает платежный счет клиента */
    public PaymentAccount getPaymentAccount() {
        return this.paymentAccount;
    }

    /** Функция получения значения поля {@link User#creditRate}
     * @return возвращает кредитный счет клиента */
    public Integer getCreditRate() {
        return this.creditRate;
    }

    /** Процедура определения идентификатора клиента {@link User#id}
     * @param id идентификатор клиента */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Процедура определения ФИО клиента {@link User#fullName}
     * @param fullName ФИО клиента */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** Процедура определения даты рождения клиента {@link User#birthDate}
     * @param birthDate дата рождения клиента */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /** Процедура определения места работы клиента {@link User#workPlace}
     * @param workPlace место работы клиента */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    /** Процедура определения месячный доход клиента {@link User#monthIncome}
     * @param monthIncome месячный доход клиента */
    public void setMonthIncome(Integer monthIncome) {
        this.monthIncome = monthIncome;
    }

    /** Процедура определения банка клиента {@link User#bank}
     * @param bank банка клиента */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /** Процедура определения кредитного клиента {@link User#creditAccount}
     * @param creditAccount кредитный счет клиента */
    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

    /** Процедура определения платежный клиента {@link User#paymentAccount}
     * @param paymentAccount платежный счет клиента */
    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /** Процедура определения кредитного рейтинга клиента {@link User#creditRate}
     * @param creditRate кредитный рейтинг клиента */
    public void setCreditRate(Integer creditRate) {
        this.creditRate = creditRate;
    }

}
