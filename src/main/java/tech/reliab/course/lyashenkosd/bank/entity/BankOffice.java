package tech.reliab.course.lyashenkosd.bank.entity;

/**  Класс-модель банковский офис со свойствами: <br> <b>{@link BankOffice#id}</b>, <br> <b>{@link BankOffice#name}</b>,
 * <br> <b>{@link BankOffice#address}</b>, <br> <b>{@link BankOffice#activityStatus}</b>,
 * <br> <b>{@link BankOffice#mayToCreditStatus}</b>, <br> <b>{@link BankOffice#atmQty}</b>,
 * <br> <b>{@link BankOffice#mayToCreditStatus}</b>, <br> <b>{@link BankOffice#cashOutStatus}</b>,
 * <br> <b>{@link BankOffice#cashInStatus}</b>, <br> <b>{@link BankOffice#moneyQtyInOffice}</b>,
 * <br> <b>{@link BankOffice#rent}</b>
 * @see tech.reliab.course.lyashenkosd.bank.service.BankOfficeService*/
public class BankOffice {
    /** Поле идентификатор банковского офиса */
    private Integer id;

    /** Поле название банковского офиса */
    private String name;

    /** Поле адрес банковского офиса */
    private String address;

    /** Поле статус работы офиса */
    private Boolean activityStatus;

    /** Поле есть ли возможность разместить банкомат */
    private Boolean mayToLocateAtmStatus;

    /** Поле количество банкоматов в офисе */
    private Integer atmQty;

    /** Поле возможность выдавать кредиты в офисе */
    private Boolean mayToCreditStatus;

    /** Возможность снять деньги в офисе */
    private Boolean cashOutStatus;

    /** Возможность положить деньги в офисе */
    private Boolean cashInStatus;

    /** Поле количество денег в офисе */
    private Integer moneyQtyInOffice;

    /** Поле стоимость аренды банковского офиса */
    private Integer rent;

    /** Конструктор */
    public BankOffice(Integer id, String name, String address) {
        setId(id);
        setName(name);
        setAddress(address);
        setActivityStatus(false);
        setMayToLocateAtmStatus(false);
        setAtmQty(0);
        setMayToCreditStatus(false);
        setCashingOutStatus(false);
        setCashingInStatus(false);
        setMoneyQtyInOffice(0);
        setRent(0);
    }

    /** Перегрузка функции toString()
     * для возвращения информации о банковском офисе в виде строки */
    @Override
    public String toString(){
        return "\nБанковский офис{" +
                "\nID Офиса: " + getId() +
                ",\nНазвание: " + getName() +
                ",\nАдрес: " + getAddress() +
                ",\nАктивность: " + getActivityStatus() +
                ",\nВозможность разместить банкомат: " + getMayToLocateAtmStatus() +
                ",\nКол-во банкоматов в офисе: " + getAtmQty() +
                ",\nВозможность взять кредит: " + getMayToCreditStatus() +
                ",\nВозможность снять деньги: " + getCashingOutStatus() +
                ",\nВозможность внести деньги: " + getCashingInStatus() +
                ",\nКол-во денег в офисе: " + getMoneyQtyInOffice() +
                ",\nСтоимость аренды: " + getRent() +
                "\n}";
    }

    /** Функция получения значения поля {@link BankOffice#id}
     * @return возвращает id номер банковского офиса */
    public Integer getId(){
        return this.id;
    }

    /** Функция получения значения поля {@link BankOffice#name}
     * @return возвращает название банковского офиса */
    public String getName(){
        return this.name;
    }

    /** Функция получения значения поля {@link BankOffice#address}
     * @return возвращает адрес банковского офиса */
    public String getAddress(){
        return this.address;
    }

    /** Функция получения значения поля {@link BankOffice#activityStatus}
     * @return возвращает статус работы банковского офиса */
    public Boolean getActivityStatus(){
        return this.activityStatus;
    }

    /** Функция получения значения поля {@link BankOffice#mayToLocateAtmStatus}
     * @return <b>true</b>, если есть возможность разместить банкомат <br>
     *  <b>false</b>, если нет возможности разместить банкомат */
    public Boolean getMayToLocateAtmStatus(){
        return this.mayToLocateAtmStatus;
    }

    /** Функция получения значения поля {@link BankOffice#atmQty}
     * @return возвращает количество банкоматов в банковском офисе */
    public Integer getAtmQty(){
        return this.atmQty;
    }

    /** Функция получения значения поля {@link BankOffice#mayToCreditStatus}
     * @return <b>true</b>, если есть возможность выдавать кредиты <br>
     *  <b>false</b>, если нет возможности выдавать кредиты */
    public Boolean getMayToCreditStatus(){
        return this.mayToCreditStatus;
    }

    /** Функция получения значения поля {@link BankOffice#cashOutStatus}
     * @return <b>true</b>>, если есть возможность снимать деньги <br>
     *  <b>false</b>, если нет возможности снимать деньги */
    public Boolean getCashingOutStatus(){
        return this.cashOutStatus;
    }

    /** Функция получения значения поля {@link BankOffice#cashInStatus}
     * @return <b>true</b>, если есть возможность положить деньги <br>
     *  <b>false</b>, если нет возможности положить деньги */
    public Boolean getCashingInStatus(){
        return this.cashInStatus;
    }

    /** Функция получения значения поля {@link BankOffice#atmQty}
     * @return возвращает количество денег в банковском офисе */
    public Integer getMoneyQtyInOffice(){
        return this.moneyQtyInOffice;
    }

    /** Функция получения значения поля {@link BankOffice#rent}
     * @return возвращает стоимость аренды банковского офиса */
    public Integer getRent(){
        return this.rent;
    }

    /** Процедура определения идентификатора банковского офиса {@link BankOffice#id}
     * @param id идентификатор банковского офиса */
    public void setId(Integer id){
        this.id = id;
    }

    /** Процедура определения названия банковского офиса {@link BankOffice#name}
     * @param name название банковского офиса */
    public void setName(String name){
        this.name = name;
    }

    /** Процедура определения адреса банковского офиса {@link BankOffice#address}
     * @param address адрес банковского офиса */
    public void setAddress(String address){
        this.address = address;
    }

    /** Процедура определения статуса работы банковского офиса {@link BankOffice#activityStatus}
     * @param activityStatus статус работы банковского офиса */
    public void setActivityStatus(Boolean activityStatus) {
        this.activityStatus = activityStatus;
    }

    /** Процедура определения возможности разместить банкомат в банковском офисе {@link BankOffice#mayToLocateAtmStatus}
     * @param mayToLocateAtmStatus возможность разместить банкомат в офисе <br>
     * <b>true</b> - да <br>
     * <b>false</b> - нет*/
    public void setMayToLocateAtmStatus(Boolean mayToLocateAtmStatus) {
        this.mayToLocateAtmStatus = mayToLocateAtmStatus;
    }

    /** Процедура определения количества банкоматов в банковском офисе {@link BankOffice#atmQty}
     * @param atmQty количество банкоматов в банковском офисе */
    public void setAtmQty(Integer atmQty){
        this.atmQty = atmQty;
    }

    /** Процедура определения возможности выдавать кредиты в банковском офисе {@link BankOffice#mayToCreditStatus}
     * @param mayToCreditStatus возможность выдавать кредиты в офисе в офисе <br>
     * <b>true</b> - да <br>
     * <b>false</b> - нет*/
    public void setMayToCreditStatus(Boolean mayToCreditStatus) {
        this.mayToCreditStatus = mayToCreditStatus;
    }

    /** Процедура определения возможности снимать деньги в банковском офисе {@link BankOffice#cashOutStatus}
     * @param cashOutStatus возможность снимать деньги в офисе в офисе <br>
     * <b>true</b> - да <br>
     * <b>false</b> - нет*/
    public void setCashingOutStatus(Boolean cashOutStatus) {
        this.cashOutStatus = cashOutStatus;
    }

    /** Процедура определения возможности вносить деньги в банковском офисе {@link BankOffice#cashInStatus}
     * @param cashInStatus возможность вносить деньги в офисе в офисе <br>
     * <b>true</b> - да <br>
     * <b>false</b> - нет*/
    public void setCashingInStatus(Boolean cashInStatus) {
        this.cashInStatus = cashInStatus;
    }

    /** Процедура определения количества денег в банковском офисе {@link BankOffice#moneyQtyInOffice}
     * @param moneyQtyInOffice количество денег в банковском офисе */
    public void setMoneyQtyInOffice(Integer moneyQtyInOffice) {
        this.moneyQtyInOffice = moneyQtyInOffice;
    }

    /** Процедура определения стоимости аренды банковского офиса {@link BankOffice#rent}
     * @param rent стоимость аренды банковского офиса */
    public void setRent(Integer rent) {
        this.rent = rent;
    }
}
