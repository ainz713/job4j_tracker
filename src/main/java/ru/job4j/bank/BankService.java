package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банка по взаимодействию с клиентом
 * @author ALEKSEY DYUZHEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа Map
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и добавляет его в БД
     * @param user клиент, который добавляется в существующую БД
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт для идентификации клиента и добавления ему счета
     * @param passport паспорт для идентификации клиента
     * @param account счет, который добавляется
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает на вход паспорт для поиска клиента по нему
     * @param passport паспорт для идентификации клиента
     * @return возвращает клиента с таким паспортом
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
              return key;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт для поиска клиента и реквизиты для поиска счета
     * @param passport паспорт для поиска клиента
     * @param requisite реквизиты счета для поиска счета
     * @return возвращает счет с указанными реквизитами
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> account = users.get(user);
        if (user != null && account != null) {
            for (Account e
                    :account) {
                if (e.getRequisite().equals(requisite)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты счета для поиска счета с которого переводятся
     * деньги, а также паспорт, реквизиты счета - на который переводятся деньги с указанием суммы
     * @param srcPassport паспорт для определения счета, с которого переводятся деньги
     * @param srcRequisite реквзиты для определения счета, с которого переводятся деньги
     * @param destPassport паспорт для определения счета, куда переводятся деньги
     * @param destRequisite реквзиты для определения счета, куда переводятся деньги
     * @param amount сумма перевода между счетами
     * @return возвращает true в случае успешного перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account account = findByRequisite(srcPassport, srcRequisite);
        Account account2 = findByRequisite(destPassport, destRequisite);
        if (account == null || account2 == null || account.getBalance() < amount) {
            return rsl;
        } else {
            double b = account.getBalance();
            double d = account2.getBalance();
            account2.setBalance(amount + d);
            account.setBalance(b - amount);
            rsl = true;
        }
        return rsl;
    }
}
