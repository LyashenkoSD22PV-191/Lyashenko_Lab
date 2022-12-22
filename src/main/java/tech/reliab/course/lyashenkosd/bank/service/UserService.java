package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.User;

import java.time.LocalDate;

/** Интерфейс операций, связанных с классом {@link User}
 * @version 0.1 */
public interface UserService {

    /** Процедура получения полной информации о клиенте
     * @param id идентификатор клиента */
    void getAllInformation(Integer id);

    /** Процедура создания экземпляра {@link User} */
    void createUser (Integer id, String fullName, LocalDate birthDate, String workPlace);

    /** Функция получения экземпляра {@link User}
     * @param id идентификатор пользователя
     * @return объект класса {@link User}*/
    User getUser(Integer id);

    /**
     * Процедура смены места работы
     * @param user      клиент, которому необходимо сменить место работы
     * @param workPlace место работы клиента
     */
    void changeWorkPlace(User user, String workPlace);

    /** Удаление данных о пользователе
     * @param user клиент, экземпляр класса User, который требуется удалить
     * @return null
     */
    public User delete(User user);
}
