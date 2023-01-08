package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.*;
import tech.reliab.course.lyashenkosd.bank.service.*;
import tech.reliab.course.lyashenkosd.bank.utils.UserException;

import static tech.reliab.course.lyashenkosd.bank.utils.Constants.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** Класс-реализация операций клиента, реализует интерфейс клиента {@link User} <br>
 * Реализуется бизнес-логика. Singleton
 */
public class UserServiceOperations implements UserService {

    /* Сервисы нам нужны, чтобы получать интересующую нас информацию о сущностях  */
    BankService bankService = BankServiceOperations.BANK_SERVICE;
    BankOfficeService bankOfficeService = BankOfficeServiceOperations.BANK_OFFICE_SERVICE;
    EmployeeService employeeService = EmployeeServiceOperations.EMPLOYEE_SERVICE;
    AtmService atmService = AtmServiceOperations.ATM_SERVICE;

    private final Map<Integer, User> users = new HashMap<>();

    private UserServiceOperations() {
    }

    public static final UserService USER_SERVICE = new UserServiceOperations();

    @Override
    public int[] searchPlaceForGiveCredit(Integer money) throws UserException {

        /* Сразу инициализируем массив, который мы будем возвращать */
        int[] idArray = new int[2];

        /* Все подходящие элементы мы будем сохранять в массивы */
        Map<Integer, Bank> banks = new HashMap<>(); /* Все банки, которые подходят клиенту */
        Map<Integer, BankOffice> offices = new HashMap<>(); /* Все офисы, которые подходят клиенту */
        Map<Integer, Employee> employees = new HashMap<>(); /* Все сотрудники, которые подходят клиенту */
        Map<Integer, BankAtm> atms = new HashMap<>(); /* Все банкоматы, которые подходят клиенту */

        /* Перебираем все банки, которые существуют */
        for (int bankIndex = 1; bankIndex <= QUANTITY_BANKS; bankIndex++) {
            /* Перебираем все офисы и проверяем: принадлежит ли офис этому банку? */
            for (int officeIndex = 1; officeIndex <= QUANTITY_OFFICE; officeIndex++) {
                BankOffice office = bankOfficeService.getBankOffice(officeIndex);
                if (office.getBankId() == bankIndex && /* Если офис принадлежит банку и */
                        office.getActivityStatus() && /* Если офис работает и */
                        office.getMayToCreditStatus() && /* Если офис может выдавать кредиты и */
                        office.getMoneyQtyInOffice() > money) { /* Кол-во денег в офисе больше, чем сумма кредита */
                    /* Значит, нам нужно найти сотрудника в этом офисе, который может выдавать кредиты */
                    for (int employeeIndex = 1; employeeIndex <= QUANTITY_EMPLOYEES; employeeIndex++) {
                        Employee employee = employeeService.getEmployee(employeeIndex);
                        if (employee.getBankOffice().getId() == officeIndex && /* Если сотрудник работает в офисе */
                                employee.getMayToGiveCredit()) { /* и имеет выдавать кредиты */
                            for (int atmIndex = 1; atmIndex <= QUANTITY_ATMS; atmIndex++) { /* Значит ищем банкомат */
                                BankAtm atm = atmService.getAtm(atmIndex);
                                if (atm.getBankOfficeId() == officeIndex && /* Если банкомат принадлежит офису */
                                        atm.getStatus() == BankAtm.Status.WORKING /*Если банкомата статус "Работает"*/
                                        && atm.getCashOutStatus() && /* Если с банкомата можно снимать деньги */
                                        atm.getMoneyQtyInAtm() >= money /* Если в банкомате есть нужное кол-во денег */
                                ) {
                                    /* Мы нашли что искали, теперь надо занести в список возможных мест для кредита
                                     * Если такую сущность мы ещё не сохраняли, тогда сохраним */
                                    if (!banks.containsValue(bankService.getBank(bankIndex))) {
                                        banks.put(banks.size() + 1, bankService.getBank(bankIndex));
                                    }

                                    if (!offices.containsValue(bankOfficeService.getBankOffice(officeIndex))) {
                                        offices.put(offices.size() + 1, office);
                                    }

                                    if (!employees.containsValue(employeeService.getEmployee(employeeIndex))) {
                                        employees.put(employees.size() + 1, employee);
                                    }

                                    if (!atms.containsValue(atmService.getAtm(atmIndex))) {
                                        atms.put(atms.size() + 1, atm);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        /* Если мы не нашли ни одного банка, который может выдать нам кредит */
        if (banks.size() == 0) {
            throw new UserException("Не найдено подходящих банков");
        } else { /* Если нашли, то даём пользователю сделать выбор */
            for (int i = 1; i <= banks.size(); i++) { /* Выводим все банки списком */
                Bank bank = banks.get(i);
                System.out.printf("%d - %s: rating = %d, interestRate = %.2f \n",
                        i, bank.getName(), bank.getRate(), bank.getPercent());
            }
            Scanner in = new Scanner(System.in);
            System.out.print("Выберите номер банка: ");
            int bankId = in.nextInt();

            /* Здесь можно было обойтись и без этого исключения
             * Вставив в while выбор, но надо набрать 5 исключений */
            if (!banks.containsValue(banks.get(bankId))) {
                throw new UserException("Такого номера в списке банков нет");
            }

            System.out.println("Вы выбрали банк: " + banks.get(bankId));
            bankId = banks.get(bankId).getId(); /* Здесь мы берем уже настоящий id банка */
            idArray[0] = bankId; /* Запоминаем банк */
            for (int i = 1; i <= offices.size(); i++) { /* Выводим все офисы банка */
                BankOffice office = offices.get(i);
                if (office.getBankId() == bankId) {
                    System.out.printf("%d - %s, address: %s \n", i, office.getName(), office.getAddress());
                }
            }
            System.out.print("Выберите офис, в котором хотите получить кредит: ");
            int officeId = in.nextInt();

            if (!offices.containsValue(offices.get(officeId))) {
                throw new UserException("Такого офиса в списке офисов нет");
            }

            System.out.println("Вы выбрали офис: " + offices.get(officeId));
            officeId = offices.get(officeId).getId();

            for (int i = 1; i <= employees.size(); i++) {
                Employee employee = employees.get(i);
                if (employee.getBankOffice().getId() == officeId) {
                    System.out.printf("%d - %s, должность: %s \n",
                            i, employee.getFullName(), employee.getPost());
                }
            }
            System.out.print("Выберите сотрудника: ");
            int employeeId = in.nextInt();
            if (!employees.containsValue(employees.get(employeeId))) {
                throw new UserException("Такого сотрудника нет в списке сотрудников");
            }
            employeeId = employees.get(employeeId).getId();
            idArray[1] = employeeId;
        }
        return idArray;
    }

    @Override
    public Boolean getCredit(Integer id, Integer money) throws UserException {
        PaymentAccountService paymentAccountService = PaymentServiceOperations.PAYMENT_ACCOUNT_SERVICE;
        CreditAccountService creditAccountService = CreditAccountServiceOperations.CREDIT_ACCOUNT_SERVICE;

        if (id <= 0 || id > QUANTITY_USERS) {
            throw new UserException("Такого пользователя не существует");
        }

        if (money <= 0) {
            throw new UserException("Кредит не может быть выдан на отрицательную сумму");
        }

        int[] idArray = searchPlaceForGiveCredit(money);
        User user = users.get(id);
        Bank bank = bankService.getBank(idArray[0]);
        Scanner in = new Scanner(System.in);

        boolean isUserClient = false;
        int payAccId = 0;

        /* Проверяем рейтинг банка, согласно условиям */
        if (user.getCreditRate() < 5000 && bank.getRate() > 50) {
            throw new UserException("Ваш рейтинг слишком мал!");
        } else {
            /* Проверяем является ли пользователь клиентом данного банка */
            if (!isUserClient) {
                System.out.println("У вас отсутствует счет в этом банке, желаете завести? \n");
                System.out.println("1 - да \n");
                System.out.println("0 - нет \n");
                System.out.println("Ваш выбор: ");
                if (in.nextInt() == 1) {
                    payAccId = QUANTITY_PAYS_AND_CREDITS + 1;
                    paymentAccountService.createPaymentAccount(bank, user, payAccId, 0);
                } else {
                    throw new UserException("Невозможно выдать кредит, если у вас не будет счета");
                }
            }
            System.out.println("Ваш платежный счет:");
            System.out.println(paymentAccountService.getPaymentAccount(payAccId));
            System.out.print("На сколько месяцев вы хотите получить кредит: ");
            int countMonths = in.nextInt();
            LocalDate dateStart = LocalDate.now();
            LocalDate dateFinish = dateStart.plusMonths(countMonths);
            creditAccountService.createCreditAccount(
                    bank,
                    user,
                    employeeService.getEmployee(idArray[1]),
                    paymentAccountService.getPaymentAccount(payAccId),
                    QUANTITY_PAYS_AND_CREDITS + 1,
                    dateStart,
                    dateFinish,
                    countMonths,
                    money,
                    (money + money * (bank.getRate() / 100)) / countMonths);
            System.out.println("Кредит успешно выдан!");
            System.out.println(creditAccountService.getCreditAccount(QUANTITY_PAYS_AND_CREDITS + 1));
        }
        return true;
    }

    @Override
    public void getAllInformation(Integer id) {
        PaymentAccountService paymentAccountService = PaymentServiceOperations.PAYMENT_ACCOUNT_SERVICE;
        CreditAccountService creditAccountService = CreditAccountServiceOperations.CREDIT_ACCOUNT_SERVICE;

        System.out.println("Информация о пользователе: " + getUser(id).getFullName());


        for (int i = 1; i <= QUANTITY_PAYS_AND_CREDITS; i++) {
            if (id == paymentAccountService.getPaymentAccount(i).getUser().getId()) {
                System.out.println(paymentAccountService.getPaymentAccount(i));
            }
        }

        for (int i = 1; i <= QUANTITY_PAYS_AND_CREDITS; i++) {
            if (id == creditAccountService.getCreditAccount(i).getUser().getId()) {
                System.out.println(creditAccountService.getCreditAccount(i));
            }
        }
    }

    @Override
    public void createUser(Integer id, String fullName, LocalDate birthDate, String workPlace) {
        users.put(id, new User(id, fullName, birthDate, workPlace));
    }

    @Override
    public User getUser(Integer id) {
        return users.get(id);
    }

    public void changeWorkPlace(User user, String workPlace) {
        user.setWorkPlace(workPlace);
    }

}