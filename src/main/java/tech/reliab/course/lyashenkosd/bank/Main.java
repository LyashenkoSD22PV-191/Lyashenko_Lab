package tech.reliab.course.lyashenkosd.bank;

import tech.reliab.course.lyashenkosd.bank.entity.*;
import tech.reliab.course.lyashenkosd.bank.service.*;
import tech.reliab.course.lyashenkosd.bank.service.impl.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank(1, "myBank");
        BankService bankService = BankServiceOperations.BANK_SERVICE;

        bankService.addOffice(bank);
        bankService.addClient(bank);
        bankService.addEmployee(bank);
        bankService.addAtm(bank);
        System.out.println(bank);

        BankOffice bankOffice = new BankOffice(1, "Отделение №1", "улица Пушкина дом Колотушкина");
        BankOfficeService bankOfficeService = BankOfficeServiceOperations.BANK_OFFICE_SERVICE;
        bankOfficeService.addAtm(bankOffice);
        System.out.println(bankOffice);

        Employee employee = new Employee(1, "Бруснецева", LocalDate.of(1488, 1, 1), bank, bankOffice, "Уборщик туалетов");
        EmployeeService employeeService = EmployeeServiceOperations.EMPLOYEE_SERVICE;
        employeeService.addSalary(employee, 228322);
        System.out.println(employee);

        AtmService atmService = AtmServiceOperations.ATM_SERVICE;
        BankAtm bankAtm = new BankAtm(1, "Samsung", bank, bankOffice, employee);
        atmService.addMoney(bankAtm, 228322);
        System.out.println(bankAtm);

        User user = new User(1, "Ляшенко Сергей", LocalDate.of(2000,9,11), "Sber", bank);

        PaymentAccount paymentAccount = new PaymentAccount(1, user, bank);
        PaymentAccountService paymentService = PaymentServiceOperations.PAYMENT_ACCOUNT_SERVICE;
        paymentService.addMoney(paymentAccount, 228322);
        System.out.println(paymentAccount);

        CreditAccount creditAccount = new CreditAccount(1, user, bank, employee, paymentAccount);
        CreditAccountService creditAccountService = CreditAccountServiceOperations.CREDIT_ACCOUNT_SERVICE;
        creditAccountService.subCreditSum(creditAccount, 0);
        System.out.println(creditAccount);

        UserService userService = UserServiceOperations.USER_SERVICE;
        userService.changeWorkPlace(user, "БГТУ");
        System.out.println(user);


        System.out.print("\nУдаление:");

        bank = null;
        System.out.print("\nБанк: " + bank);

        bankOffice = null;
        System.out.print("\nБанковский офис: " + bankOffice);

        bankAtm = null;
        System.out.print("\nАТМ: " + bankAtm);

        employee = null;
        System.out.print("\nСотрудник: " + employee);

        creditAccount = null;
        System.out.print("\nКредитный аккаунт: " + creditAccount);

        paymentAccount = null;
        System.out.print("\nПлатежный аккаунт: " + paymentAccount);

        user = null;
        System.out.print("\nПользователь: " + user);
    }
}
