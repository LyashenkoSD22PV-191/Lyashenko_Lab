package tech.reliab.course.lyashenkosd.bank.service.impl;

import tech.reliab.course.lyashenkosd.bank.entity.User;
import tech.reliab.course.lyashenkosd.bank.service.CreditAccountService;
import tech.reliab.course.lyashenkosd.bank.service.PaymentAccountService;
import tech.reliab.course.lyashenkosd.bank.service.UserService;
import static tech.reliab.course.lyashenkosd.bank.utils.Constants.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/** Класс-реализация операций клиента, реализует интерфейс клиента {@link User} <br>
 * Реализуется бизнес-логика. Singleton*/
public class UserServiceOperations implements UserService {

    private final Map<Integer, User> users = new HashMap<>();

    private UserServiceOperations(){}

    public static final UserService USER_SERVICE = new UserServiceOperations();

    @Override
    public void getAllInformation(Integer id) {
        PaymentAccountService paymentAccountService = PaymentServiceOperations.PAYMENT_ACCOUNT_SERVICE;
        CreditAccountService creditAccountService = CreditAccountServiceOperations.CREDIT_ACCOUNT_SERVICE;

        System.out.println("Информация о пользователе: " + getUser(id).getFullName());


        for (int i = 1; i <= QUANTITY_PAYS_AND_CREDITS; i++){
            if(id == paymentAccountService.getPaymentAccount(i).getUser().getId()){
                System.out.println(paymentAccountService.getPaymentAccount(i));
            }
        }

        for (int i = 1; i <= QUANTITY_PAYS_AND_CREDITS; i++){
            if (id == creditAccountService.getCreditAccount(i).getUser().getId()){
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

    public void changeWorkPlace(User user, String workPlace){
        user.setWorkPlace(workPlace);
    }

}
