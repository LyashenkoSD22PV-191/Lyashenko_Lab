package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.Bank;
import tech.reliab.course.lyashenkosd.bank.service.*;

import static tech.reliab.course.lyashenkosd.bank.utils.Constants.*;

import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций банка, реализует интерфейс банковского сервиса {@link BankService}. <br>
 * Реализуется бизнес-логика. <br> Singleton*/
public class BankServiceOperations implements BankService {

    private final Map<Integer, Bank> banks = new HashMap<>();

    private BankServiceOperations(){}

    public static final BankService BANK_SERVICE = new BankServiceOperations();

    @Override
    public void getAllInformation(Integer id) {
        BankOfficeService bankOfficeService = BankOfficeServiceOperations.BANK_OFFICE_SERVICE;
        AtmService atmService = AtmServiceOperations.ATM_SERVICE;
        EmployeeService employeeService = EmployeeServiceOperations.EMPLOYEE_SERVICE;
        UserService userService = UserServiceOperations.USER_SERVICE;

        System.out.println("Информация о банке: " + getBank(id).getName());

        for (int i = 1; i <= QUANTITY_OFFICE; i++){
            if (id == bankOfficeService.getBankOffice(i).getBankId()){
                System.out.println(bankOfficeService.getBankOffice(i));
            }
        }

        for (int i = 1; i <= QUANTITY_ATMS; i++){
            if (id == atmService.getAtm(i).getBank().getId()){
                System.out.println(atmService.getAtm(i));
            }
        }

        for (int i = 1; i <= QUANTITY_EMPLOYEES; i++){
            if(id == employeeService.getEmployee(i).getBank().getId()){
                System.out.println(employeeService.getEmployee(i));
            }
        }

        for (int i = 1; i <= QUANTITY_USERS; i++){
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
        banks.put(id, new Bank(id, name));
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
