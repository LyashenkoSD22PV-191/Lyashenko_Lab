package tech.reliab.course.lyashenkosd.bank.service;

import tech.reliab.course.lyashenkosd.bank.entity.User;

/** Интерфейс операций, связанных с классом {@link User}
 * @version 0.1 */
public interface UserService {

    /**
     * Процедура смены места работы
     * @param user      клиент, которому необходимо сменить место работы
     * @param workPlace место работы клиента
     */
    void changeWorkPlace(User user, String workPlace);
}
