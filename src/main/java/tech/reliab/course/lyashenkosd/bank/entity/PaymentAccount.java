package tech.reliab.course.lyashenkosd.bank.entity;

/** Класс-модель платежного счета со свойствами: <br> <b>{@link PaymentAccount#id}</b>,
 * <br> <b>{@link PaymentAccount#user}</b>, <br> <b>{@link PaymentAccount#bank}</b>,
 * <br> <b>{@link PaymentAccount#currentSum}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.PaymentAccountService*/
public class PaymentAccount {

    /** Поле идентификатор платежного счета */
    private Integer id;

    /** Поле пользователя платежного счета
     * @see User */
    private User user;

    /** Поле банка-владельца, где открыт платежный счет
     * @see Bank */
    private Bank bank;

    /** Поле текущей суммы на платежном счете */
    private Integer currentSum;

    /** Конструктор */
    public PaymentAccount(Bank bank, User user, Integer id, Integer currentSum){
        setBank(bank);
        setUser(user);
        setId(id);
        setCurrentSum(currentSum);
    }

    /** Перегрузка функции toString()
     * для возвращения информации о платежном счете в виде строки*/
    @Override
    public String toString(){
        return "\nПлатежный счет{" +
                "\nID счета: " + getId() +
                ",\nПользователь счета: " + getUser().getFullName() +
                ",\nБанк счета: " + getBank().getName() +
                ",\nТекущая сумма: " + getCurrentSum() +
                "\n}";
    }

    /** Функция получения значения поля {@link PaymentAccount#id}
     * @return возвращает id номер платежного счета */
    public Integer getId() {
        return this.id;
    }

    /** Функция получения значения поля {@link PaymentAccount#user}
     * @return возвращает пользователя платежного счета
     * @see User*/
    public User getUser() {
        return this.user;
    }

    /** Функция получения значения поля {@link PaymentAccount#bank}
     * @return возвращает банк-владельца платежного счета
     * @see Bank*/
    public Bank getBank() {
        return this.bank;
    }

    /** Функция получения значения поля {@link PaymentAccount#currentSum}
     * @return возвращает текущую сумму платежного счета */
    public Integer getCurrentSum() {
        return this.currentSum;
    }

    /** Процедура определения идентификатора платежного счета {@link PaymentAccount#id}
     * @param id идентификатор платежного счета */
    public void setId(Integer id) {
        this.id = id;
    }

    /** Процедура определения пользователя платежного счета {@link PaymentAccount#user}
     * @param user пользователь платежного счета
     * @see User*/
    public void setUser(User user) {
        this.user = user;
    }

    /** Процедура определения банка-владельца платежного счета {@link PaymentAccount#bank}
     * @param bank банк-владелец платежного счета
     * @see Bank*/
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /** Процедура определения текущей суммы платежного счета {@link PaymentAccount#currentSum}
     * @param currentSum текущая сумма платежного счета */
    public void setCurrentSum(Integer currentSum) {
        this.currentSum = currentSum;
    }


}
