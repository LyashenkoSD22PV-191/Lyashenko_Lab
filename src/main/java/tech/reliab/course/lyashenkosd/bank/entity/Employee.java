package tech.reliab.course.lyashenkosd.bank.entity;

import java.time.LocalDate;

/** Класс-модель сотрудника со свойствами: <br> <b>{@link Employee#id}</b>, <br> <b>{@link Employee#fullName}</b>,
 * <br> <b>{@link Employee#birthDate}</b>, <br> <b>{@link Employee#post}</b>, <br> <b>{@link Employee#bank}</b>,
 * <br> <b>{@link Employee#onlineOrNot}</b>, <br> <b>{@link Employee#bankOffice}</b>,
 * <br> <b>{@link Employee#mayToGiveCredit}</b>, <br> <b>{@link Employee#salary}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.EmployeeService
 * */
public class Employee {
    /**
     * Поле идентификатор сотрудника
     */
    private Integer id;

    /**
     * Поле полное имя (ФИО) сотрудника
     */
    private String fullName;

    /**
     * Поле дата рождения сотрудника
     */
    private LocalDate birthDate;

    /**
     * Поле должность сотрудника
     */
    private String post;

    /**
     * Поле банк, в котором работает сотрудник
     *
     * @see Bank
     */
    private Bank bank;

    /**
     * Поле работает онлайн или нет
     * <b>true</b> - сотрудник работает удаленно(онлайн)
     * <b>false</b> - сотрудник работает в офисе(офлайн)
     */
    private Boolean onlineOrNot;

    /**
     * Поле банковский офис, в котором работает сотрудник
     *
     * @see BankOffice
     */
    private BankOffice bankOffice;

    /**
     * Поле может ли выдавать кредиты
     * <b>true</b> - можете выдавать кредиты
     * <b>false</b> - не может выдавать кредиты
     */
    private Boolean mayToGiveCredit;

    /**
     * Поле зарплата сотрудника
     */
    private Integer salary;

    /**
     * Конструктор
     */
    public Employee(Integer id, String fullName, LocalDate birthDate, String post, Bank bank,
                    Boolean onlineOrNot, BankOffice bankOffice, Boolean mayToGiveCredit,
                    Integer salary) {

        setId(id);
        setFullName(fullName);
        setBirthDate(birthDate);
        setPost(post);
        setBank(bank);
        setOnlineOrNot(onlineOrNot);
        setBankOffice(bankOffice);
        setMayToGiveCredit(mayToGiveCredit);
        setSalary(salary);
    }

    /**
     * Перегрузка функции toString()
     * для возвращения информации о сотруднике в виде строки
     */
    @Override
    public String toString() {
        return "\nСотрудник{" +
                "\nID сотрудника: " + getId() +
                "\nФИО: " + getFullName() +
                "\nДата рождения: " + getBirthDate() +
                "\nРаботает в " + getBankOffice().getName() +
                "\nВозможность выдать кредит: " + getMayToGiveCredit() +
                "\nРаботает ли онлайн: " + getOnlineOrNot() +
                "\nДолжность: " + getPost() +
                "\nЗарплата: " + getSalary() +
                "\n}";
    }

    /**
     * Функция получения значения поля {@link Employee#id}
     *
     * @return возвращает id номер сотрудника
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Функция получения значения поля {@link Employee#fullName}
     *
     * @return возвращает ФИО сотрудника
     */
    public String getFullName() {
        return this.fullName;
    }

    /**
     * Функция получения значения поля {@link Employee#birthDate}
     *
     * @return возвращает дату рождения сотрудника
     */
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    /**
     * Функция получения значения поля {@link Employee#post}
     *
     * @return возвращает должность сотрудника
     */
    public String getPost() {
        return this.post;
    }

    /**
     * Функция получения значения поля {@link Employee#bank}
     *
     * @return возвращает банк, в котором работает сотрудник
     */
    public Bank getBank() {
        return this.bank;
    }

    /**
     * Функция получения значения поля {@link Employee#onlineOrNot}
     *
     * @return <b>true</b> - если работает удаленно(онлайн).<br>
     * <b>false</b> - если работает в офисе(оффлайн).
     */
    public Boolean getOnlineOrNot() {
        return this.onlineOrNot;
    }

    /**
     * Функция получения значения поля {@link Employee#bankOffice}
     *
     * @return возвращает банковский офис сотрудника
     * @see BankOffice
     */
    public BankOffice getBankOffice() {
        return this.bankOffice;
    }

    /**
     * Функция получения значения поля {@link Employee#mayToGiveCredit}
     *
     * @return <b>true</b> - если может выдавать кредиты.<br>
     * <b>false</b> - если не может выдавать.
     */
    public Boolean getMayToGiveCredit() {
        return this.mayToGiveCredit;
    }

    /**
     * Функция получения значения поля {@link Employee#salary}
     *
     * @return возвращает размер зарплаты сотрудника
     */
    public Integer getSalary() {
        return this.salary;
    }

    /**
     * Процедура определения идентификатора сотрудника {@link Employee#id}
     *
     * @param id идентификатор сотрудника
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Процедура определения ФИО сотрудника {@link Employee#fullName}
     *
     * @param fullName ФИО сотрудника
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Процедура определения дня рождения сотрудника {@link Employee#birthDate}
     *
     * @param birthDate день рождения сотрудника
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Процедура определения должности сотрудника {@link Employee#post}
     *
     * @param post должность сотрудника
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * Процедура определения банка сотрудника {@link Employee#bank}
     *
     * @param bank банк сотрудника
     * @see Bank
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * Процедура определения онлайн или офлайн сотрудник {@link Employee#onlineOrNot}
     *
     * @param onlineOrNot <br> <b>true</b> - если работает удаленно(онлайн).<br>
     *                    <b>false</b> - если работает в офисе(оффлайн).
     */
    public void setOnlineOrNot(Boolean onlineOrNot) {
        this.onlineOrNot = onlineOrNot;
    }

    /**
     * Процедура определения банковского офиса сотрудника {@link Employee#bankOffice}
     *
     * @param bankOffice банковский офис сотрудника
     * @see BankOffice
     */
    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    /**
     * Процедура определения может ли сотрудник выдавать кредиты {@link Employee#mayToGiveCredit}
     *
     * @param mayToGiveCredit <br> <b>true</b> - если может выдавать кредиты.<br>
     *                        <b>false</b> - если не может выдавать.
     */
    public void setMayToGiveCredit(Boolean mayToGiveCredit) {
        this.mayToGiveCredit = mayToGiveCredit;
    }

    /**
     * Процедура определения зарплаты {@link Employee#salary}
     *
     * @param salary зарплата сотрудника
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
