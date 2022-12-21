package tech.reliab.course.lyashenkosd.bank.entity;

/** Класс-модель банкомат со свойствами: <br> <b>{@link BankAtm#id}</b>,
 * <br> <b>{@link BankAtm#name}</b>, <br> <b>{@link BankAtm#bankOfficeId}</b>,
 *  <br> <b>{@link BankAtm#address}</b>, <br> <b>{@link BankAtm#bank}</b>, <br> <b>{@link BankAtm#employeeId}</b>,
 *   <br> <b>{@link BankAtm#cashOutStatus}</b>,  <br> <b>{@link BankAtm#cashInStatus}</b>,
 *   <br> <b>{@link BankAtm#moneyQtyInAtm}</b>, <br> <b>{@link BankAtm#status}</b>
 *   @see tech.reliab.course.lyashenkosd.bank.service.AtmService*/
public class BankAtm {

    /** Поле идентификатор */
    private Integer id;

    /** Поле идентификатор офиса, которому принадлежит банкомат */
    private Integer bankOfficeId;

    /** Поле название банкомата*/
    private String name;

    /** Поле адрес расположения банкомата. <br>
     * Совпадает с адресом банковского офиса.*/
    private String address;

    /** Поле банк, которому принадлежит банкомат <br>
     * См. также {@link Bank}*/
    private Bank bank;

    /** Поле сотрудник, который обслуживает банкомат <br>
     * @see Employee */
    private Integer employeeId;

    /** Поле возможность снять деньги */
    private Boolean cashOutStatus;

    /** Поле возможность внести деньги */
    private Boolean cashInStatus;

    /** Поле количество денег в банкомате <br>
     * Напрямую зависит от количества денег в банке <br>
     * См. также {@link Bank} поле <b>moneyQty</b>*/
    private Integer moneyQtyInAtm;

    /** Поле стоимость обслуживания банкомата */
    private Integer serviceCost;

    /** Поле статус. См. также {@link Status} <br>
     * Может принимать три значения: <br>
     * Status.WORKING - банкомат работает
     * Status.OUT_OF_SERVICE - банкомат не работает
     * Status.OUT_OF_MONEY - в банкомате нет денег*/
    private Status status;

    /** Поле возможных статусов для поля {@link BankAtm#status} */
    public enum Status{

        WORKING("Работает"),
        OUT_OF_SERVICE("Не работает"),
        OUT_OF_MONEY("Нет денег");

        /** Поле название статуса */
        private final String title;

        /** Конструктор */
        Status(String title){
            this.title = title;
        }

        /** Перегруженная функция toString() <br>
         * Возвращает поле {@link Status#title} в виде строки */
        @Override
        public String toString(){
            return title;
        }
    }

    /** Конструктор для создания объекта класса */
    public BankAtm(Bank bank, BankOffice bankOffice, Integer id, String name, Integer employeeId,
                   Boolean cashOutStatus, Boolean cashInStatus, Integer moneyQtyInAtm,
                   Integer serviceCost, Status status){
        setBank(bank);
        setBankOfficeId(bankOffice.getId());
        setId(id);
        setName(name);
        setAddress(bankOffice.getAddress());
        setEmployeeId(employeeId);
        setCashOutStatus(cashOutStatus);
        setCashIntStatus(cashInStatus);
        setMoneyQtyInAtm(moneyQtyInAtm);
        setServiceCost(serviceCost);
        setStatus(status);
    }

    /** Перегруженная функция toString() <br>
     *  Возвращает информацию о банкомате в виде строки */
    @Override
    public String toString(){
        return "\nБанкомат{" +
                "\nID Банкомата: " + getId() +
                "\nID Офиса: " + getBankOfficeId() +
                ",\nНазвание: " + getName() +
                ",\nАдрес: " + getAddress() +
                ",\nСтатус: " + getStatus().toString() +
                ",\nБанк владелец: " + getBank().getName() +
                ",\nСотрудник №: " + getEmployeeId() +
                ",\nВыдача денег: " + getCashOutStatus() +
                ",\nВнесение денег: " + getCashInStatus() +
                ",\nКол-во денег внутри: " + getMoneyQtyInAtm() +
                ",\nСтоимость обслуживания: " + getServiceCost() +
                "\n}";
    }

    /** Функция получения значения поля {@link BankAtm#id}
     * @return возвращает id номер банкомата */
    public Integer getId(){
        return this.id;
    }

    /** Функция получения значения поля {@link BankAtm#bankOfficeId}
     * @return возвращает id номер банковского офиса, где стоит банкомат*/
    public Integer getBankOfficeId(){
        return this.bankOfficeId;
    }

    /** Функция получения значения поля {@link BankAtm#name}
     * @return возвращает название банкомата */
    public String getName(){
        return this.name;
    }

    /** Функция получения значения поля {@link BankAtm#address}
     * @return возвращает адрес банкомата */
    public String getAddress(){
        return this.address;
    }

    /** Функция получения значения поля {@link BankAtm#bank}
     * @return возвращает банк, которому принадлежит банкомат */
    public Bank getBank(){
        return this.bank;
    }

    /** Функция получения значения поля {@link BankAtm#employeeId}
     * @return возвращает сотрудника, который обслуживает банкомат */
    public Integer getEmployeeId(){
        return this.employeeId;
    }

    /** Функция получения значения поля {@link BankAtm#cashOutStatus}
     * @return true, если есть возможность положить деньги <br>
     *  false, если нет возможности положить деньги */
    public Boolean getCashOutStatus(){
        return this.cashOutStatus;
    }

    /** Функция получения значения поля {@link BankAtm#cashInStatus}
     * @return true, если есть возможность положить деньги <br>
     *  false, если нет возможности положить деньги */
    public Boolean getCashInStatus(){
        return this.cashInStatus;
    }

    /** Функция получения значения поля {@link BankAtm#moneyQtyInAtm}
     * @return возвращает количество денег в банкомате */
    public Integer getMoneyQtyInAtm(){
        return this.moneyQtyInAtm;
    }

    /** Функция получения значения поля {@link BankAtm#serviceCost}
     * @return возвращает статус возможности положить деньги в банкомат */
    public Integer getServiceCost(){
        return this.serviceCost;
    }

    /** Функция получения значения поля {@link BankAtm#status}
     * @return возвращает статус работы банкомата */
    public Status getStatus(){
        return this.status;
    }

    /** Процедура определения идентификатора банкомата {@link BankAtm#id}
     * @param id идентификатор */
    public void setId(Integer id){
        this.id = id;
    }

    /** Процедура определения идентификатора банковского офиса,
     * где стоит банкомат
     * @param bankOfficeId id офиса*/
    public void setBankOfficeId(Integer bankOfficeId) {
        this.bankOfficeId = bankOfficeId;
    }

    /** Процедура определения названия банкомата {@link BankAtm#name}
     * @param name название банка */
    public void setName(String name){
        this.name = name;
    }

    /** Процедура определения адреса банкомата {@link BankAtm#address}
     * @param address адрес банкомата */
    public void setAddress(String address){
        this.address = address;
    }

    /** Процедура определения банка-собственника банкомата {@link BankAtm#bank}
     * @param bank банк-собственник банкомата */
    public void setBank(Bank bank){
        this.bank = bank;
    }

    /** Процедура определения сотрудника банкомата {@link BankAtm#employeeId}
     * @param employeeId идентификатор сотрудника, который обсуживает банкомат */
    public void setEmployeeId(Integer employeeId){
        this.employeeId = employeeId;
    }

    /** Процедура определения статуса возможности снять деньги банкомата {@link BankAtm#cashOutStatus}
     * @param cashOutStatus статус возможности снять деньги с банкомата */
    public void setCashOutStatus(Boolean cashOutStatus) {
        this.cashOutStatus = cashOutStatus;
    }

    /** Процедура определения адреса банкомата {@link BankAtm#cashInStatus}
     * @param cashInStatus статус возможности положить деньги в банкомат */
    public void setCashIntStatus(Boolean cashInStatus) {
        this.cashInStatus = cashInStatus;
    }

    /** Процедура определения количества денег в банкомате {@link BankAtm#moneyQtyInAtm}
     * @param moneyQtyInAtm количество денег в банкомате */
    public void setMoneyQtyInAtm(Integer moneyQtyInAtm) {
        this.moneyQtyInAtm = moneyQtyInAtm;
    }

    /** Процедура определения стоимости обслуживания банкомата {@link BankAtm#serviceCost}
     * @param serviceCost стоимость обслуживания банкомата */
    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    /** Процедура определения статуса работы банкомата <br>
     * См. также {@link BankAtm#status}
     * @param status статус работы банкомата*/
    public void setStatus(BankAtm.Status status) {
        this.status = status;
    }

}
