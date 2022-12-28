package tech.reliab.course.lyashenkosd.bank;

import tech.reliab.course.lyashenkosd.bank.entity.BankAtm;
import tech.reliab.course.lyashenkosd.bank.service.*;
import tech.reliab.course.lyashenkosd.bank.service.impl.*;

import java.time.LocalDate;
import java.util.Scanner;

import static tech.reliab.course.lyashenkosd.bank.utils.Constants.*;


public class Main {
    public static void main(String[] args) {

        BankService bankService = BankServiceOperations.BANK_SERVICE;
        for (int i = 1; i <= QUANTITY_BANKS; i++){
            bankService.createBank(i, "bank N" + i);
        }

        BankOfficeService bankOfficeService = BankOfficeServiceOperations.BANK_OFFICE_SERVICE;
        Integer counter = 0;
        for (int i = 0; i <= QUANTITY_BANKS-1; i++){
            for (int j = 1; j <= QUANTITY_OFFICES_IN_ONE_BANK; j++){
                counter++;
                bankOfficeService.createOffice(
                        bankService.getBank(i),
                        counter,
                        "office N" + counter,
                        "address N" + counter,
                        true,
                        true,
                        0, true,
                        true, true,
                        0, 0
                );
            }
        }

        AtmService atmService = AtmServiceOperations.ATM_SERVICE;
        counter = 0;
        for (int i = 0; i <= QUANTITY_OFFICE-1; i++){
            for (int j = 1; j <= QUANTITY_ATMS_IN_ONE_OFFICE; j++){
                counter++;
                atmService.createATM(
                        bankService.getBank((bankOfficeService.getBankOffice(i).getBankId())-1),
                        bankOfficeService.getBankOffice(i),
                        counter,
                        "ATM N" + counter,
                        counter,
                        true, true,
                        0, 0,
                        BankAtm.Status.WORKING
                );
            }
        }

        EmployeeService employeeService = EmployeeServiceOperations.EMPLOYEE_SERVICE;
        counter = 0;
        for (int i = 0; i <= QUANTITY_OFFICE-1; i++){
            for (int j = 1; j <= QUANTITY_EMPLOYEES_ON_ONE_OFFICE; j++){
                counter++;
                employeeService.createEmployee(
                        counter, "Employee N" + counter,
                        LocalDate.of(2000, 1, 1),
                        "post N" + counter,
                        bankService.getBank((bankOfficeService.getBankOffice(i).getBankId())-1),
                        true, bankOfficeService.getBankOffice(i),
                        true, 0
                );
            }
        }

        UserService userService = UserServiceOperations.USER_SERVICE;
        counter = 0;
        for (int i = 0; i <= QUANTITY_BANKS-1; i++){
            for (int j = 1; j <= QUANTITY_USERS_IN_ONE_BANK; j++){
                counter++;
                userService.createUser(counter, "User N" + counter,
                                        LocalDate.of(2000, 1, 1),
                                        "workPlace N" + counter);
            }
        }

        PaymentAccountService paymentAccountService = PaymentServiceOperations.PAYMENT_ACCOUNT_SERVICE;
        CreditAccountService creditAccountService = CreditAccountServiceOperations.CREDIT_ACCOUNT_SERVICE;
        counter = 0;
        Integer userCounter = 0;
        for (int i = 0; i <= QUANTITY_BANKS-1; i++){
            for (int j = 0; j <= QUANTITY_USERS_IN_ONE_BANK-1; j++){
                userCounter++;

                for (int z = 1; z <= QUANTITY_PAYS_AND_CREDITS_IN_ONE_USER; z++){
                    counter++;
                    paymentAccountService.createPaymentAccount(
                            bankService.getBank(i),
                            userService.getUser(userCounter-1),
                            counter, 0);

                    creditAccountService.createCreditAccount(
                            bankService.getBank(i),
                            userService.getUser(userCounter-1),
                            employeeService.getEmployee(i),
                            paymentAccountService.getPaymentAccount(z-1),
                            counter,
                            LocalDate.of(2000, 1, 1),
                            LocalDate.of(2000, 1, 1),
                            12, 228000, 2280
                    );
                }
            }
        }

        for (int i = 0; i <= QUANTITY_BANKS-1; i++){
            System.out.println("----------------------");
            System.out.println("Bank" + i + "\n");
            System.out.println(bankService.getBank(i));
            System.out.println("\n");
            System.out.println("----------------------");
        }

        for (int i = 1; i <= QUANTITY_USERS-1; i++) {
            System.out.println("----------------------");
            System.out.println("User" + i + "\n");
            System.out.println(userService.getUser(i));
            System.out.println("\n");
        }

        System.out.println("1 - Банк");
        System.out.println("2 - Пользователь");
        System.out.println("Выберите, введя число ");
        Scanner in = new Scanner(System.in);
        int answer = in.nextInt();
        switch (answer) {
            case 1 -> {
                System.out.println("Введите номер банка, о котором вывести подробную информацию или 0 для вывода всех");
                answer = in.nextInt();
                if (answer == 0) {
                    for (int i = 1; i <= QUANTITY_BANKS-1; i++) {
                        bankService.getAllInformation(i);
                    }
                } else {
                    bankService.getAllInformation(answer);
                }
            }
            case 2 -> {
                System.out.println("Введите номер клиента, о котором вывести подробную информацию или 0 для вывода всех");
                answer = in.nextInt();
                if (answer == 0) {
                    for (int i = 1; i < QUANTITY_USERS-1; i++) {
                        userService.getAllInformation(i);

                    }
                } else {
                    userService.getAllInformation(answer);
                }
            }
            default -> System.out.println("Вы ввели неверное число");
        }



    }
}























