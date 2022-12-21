package tech.reliab.course.lyashenkosd.bank.entity;

import java.util.Random;

/**
 * Класс-модель банк со свойствами: <br> <b>{@link Bank#id}</b>, <br> <b>{@link Bank#name}</b>,
 * <br> <b>{@link Bank#officeQty}</b>, <br> <b>{@link Bank#atmQty}</b>, <br> <b>{@link Bank#employeeQty}</b>,
 * <br> <b>{@link Bank#clientQty}</b>, <br> <b>{@link Bank#rate}</b>, <br> <b>{@link Bank#moneyQty}</b>,
 *  <br> <b>{@link Bank#percent}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.BankService
 */
public class Bank  {
    /** Поле идентификатор банка*/
    private Integer id;

    /** Поле название банка */
    private String name;

    /** Поле количество офисов */
    private Integer officeQty;

    /** Поле количество банкоматов */
    private Integer atmQty;

    /** Поле количество сотрудников */
    private Integer employeeQty;

    /** Поле количество клиентов */
    private Integer clientQty;

    /** Поле рейтинга банка */
    private Integer rate;

    /** Поле количества денег в банке */
    private Integer moneyQty;

    /** Поле процентной ставки.
     * Зависит от поля {@link Bank#rate} (чем выше рейтинг, тем ниже ставка) */
    private Float percent;

    /** Конструктор - создание нового объекта */
    public Bank(Integer id, String name){
        setId(id);
        setName(name);
        setOfficeQty(0);
        setAtmQty(0);
        setEmployeeQty(0);
        setClientQty(0);
        Random random = new Random();
        setRate(random.nextInt(101));
        setMoneyQty(random.nextInt(1000000));
        setPercent(random.nextFloat(20));
    }

    /** Перегрузка функции toString()
     * для возвращения информации о банке в виде строки */
    @Override
    public String toString(){
        return "Банк {" +
                ",\nID Банка: " + getId() +
                ",\nНазвание: " + getName() +
                ",\nКол-во офисов: " + getOfficeQty() +
                ",\nКол-во банкоматов: " + getAtmQty() +
                ",\nКол-во сотрудников: " + getEmployeeQty() +
                ",\nКол-во клиентов: " + getClientQty() +
                ",\nРейтинг: " + getRate() +
                ",\nКол-во денег: " + getMoneyQty() +
                ",\nПроцентная ставка: " + getPercent() +
                "\n}";
    }

    /** Функция получения значения поля {@link Bank#id}
     * @return возвращает id номер банка*/
    public Integer getId(){
        return this.id;
    }

    /** Функция получения значения поля {@link Bank#name}
     * @return возвращает название банка*/
    public String getName(){
        return this.name;
    }

    /** Функция получения значения поля {@link Bank#officeQty}
     * @return возвращает количество офисов в банке*/
    public Integer getOfficeQty(){
        return this.officeQty;
    }

    /** Функция получения значения поля {@link Bank#atmQty}
     * @return возвращает количество банкоматов банка*/
    public Integer getAtmQty(){
        return this.atmQty;
    }

    /** Функция получения значения поля {@link Bank#employeeQty}
     * @return возвращает количество сотрудников банка*/
    public Integer getEmployeeQty(){
        return this.employeeQty;
    }

    /** Функция получения значения поля {@link Bank#clientQty}
     * @return возвращает количество клиентов банка*/
    public Integer getClientQty(){
        return this.clientQty;
    }

    /** Функция получения значения поля {@link Bank#rate}
     * @return возвращает значение рейтинга банка*/
    public Integer getRate(){
        return this.rate;
    }

    /** Функция получения значения поля {@link Bank#atmQty}
     * @return возвращает количество денег в банке*/
    public Integer getMoneyQty(){
        return this.moneyQty;
    }

    /** Функция получения значения поля {@link Bank#percent}
     * @return возвращает значение процентной ставки банка*/
    public Float getPercent(){
        return this.percent;
    }

    /** Процедура определения идентификатора банка {@link Bank#id}
     * @param id идентификатор */
    public void setId(Integer id){
        this.id = id;
    }

    /** Процедура определения названия банка {@link Bank#name}
     * @param name название банка */
    public void setName(String name){
        this.name = name;
    }

    /** Процедура определения количества клиентов банка {@link Bank#officeQty}
     * @param officeQty количество клиентов банка */
    public void setOfficeQty(Integer officeQty){
        this.officeQty = officeQty;
    }

    /** Процедура определения количество банкоматов банка {@link Bank#atmQty}
     * @param atmQty количество банкоматов банка */
    public void setAtmQty(Integer atmQty){
        this.atmQty = atmQty;
    }

    /** Процедура определения количества сотрудников банка {@link Bank#employeeQty}
     * @param employeeQty количество сотрудников банка */
    public void setEmployeeQty(Integer employeeQty){
        this.employeeQty = employeeQty;
    }

    /** Процедура определения количества сотрудников банка {@link Bank#clientQty}
     * @param clientQty количество клиентов банка */
    public void setClientQty(Integer clientQty){
        this.clientQty = clientQty;
    }

    /** Процедура определения рейтинга банка {@link Bank#rate}
     * @param rate рейтинг банка */
    public void setRate(Integer rate){
        this.rate = rate;
    }

    /** Процедура определения рейтинга банка {@link Bank#moneyQty}
     * @param moneyQty рейтинг банка */
    public void setMoneyQty(Integer moneyQty){
        this.moneyQty = moneyQty;
    }

    /** Процедура определения рейтинга банка {@link Bank#percent}
     * @param percent ключевая ставка банка банка */
    public void setPercent(Float percent){
        this.percent = percent;
    }

}
