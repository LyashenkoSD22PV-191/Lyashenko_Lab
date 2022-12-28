package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.service.*;

import static tech.reliab.course.lyashenkosd.bank.utils.Constants.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций банка, реализует интерфейс банковского сервиса {@link BankService}. <br>
 * Реализуется бизнес-логика. <br> Singleton*/
public class BankServiceOperations implements BankService {

    private final List<Bank> banks = new ArrayList<>();

    private BankServiceOperations(){}

    public static final BankService BANK_SERVICE = new BankServiceOperations();

    @Override
    public void getAllInformation(Integer id) {
        BankOfficeService bankOfficeService = BankOfficeServiceOperations.BANK_OFFICE_SERVICE;
        AtmService atmService = AtmServiceOperations.ATM_SERVICE;
        EmployeeService employeeService = EmployeeServiceOperations.EMPLOYEE_SERVICE;
        UserService userService = UserServiceOperations.USER_SERVICE;

        System.out.println("Информация о банке: " + getBank(id-1).getName());

        for (int i = 0; i <= QUANTITY_OFFICE-1; i++){
            if (id == bankOfficeService.getBankOffice(i).getBankId()){
                System.out.println(bankOfficeService.getBankOffice(i));
            }
        }

        for (int i = 0; i <= QUANTITY_ATMS-1; i++){
            if (id == atmService.getAtm(i).getBank().getId()){
                System.out.println(atmService.getAtm(i));
            }
        }

        for (int i = 0; i <= QUANTITY_EMPLOYEES-1; i++){
            if(id == employeeService.getEmployee(i).getBank().getId()){
                System.out.println(employeeService.getEmployee(i));
            }
        }

        for (int i = 0; i <= QUANTITY_USERS-1; i++){
            if (id == userService.getUser(i).getCreditAccount().getBank().getId()){
                System.out.println(userService.getUser(i));
            }
        }
}

    @Override
    public Bank getBank(Integer id) {
        return banks.get(id);
    }

    @Override
    public void createBank(Integer id, String name){
        banks.add(new Bank(id, name));
    }

    @Override
    public void addAtm(Bank bank) {
        bank.setAtmQty(bank.getAtmQty() + 1);
    }

    @Override
    public void addOffice(Bank bank) {
        bank.setOfficeQty(bank.getOfficeQty() + 1);
    }

    @Override
    public void addEmployee(Bank bank) {
        bank.setEmployeeQty(bank.getEmployeeQty() + 1);
    }

    @Override
    public void addClient(Bank bank) {
        bank.setClientQty(bank.getClientQty() + 1);
    }

    @Override
    public Bank delete(Bank bank){
        bank = null;
        return bank;
    }

}
