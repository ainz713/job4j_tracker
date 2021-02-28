package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод принимает на вход паспорт для поиска клиента по нему
     * @param passport паспорт для идентификации клиента
     * @return возвращает клиента с таким паспортом
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт для поиска клиента и реквизиты для поиска счета
     * @param passport паспорт для поиска клиента
     * @param requisite реквизиты счета для поиска счета
     * @return возвращает счет с указанными реквизитами
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> a = findByPassport(passport);
        if (a.isPresent()) {
            return users.get(a.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> account = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> account2 = findByRequisite(destPassport, destRequisite);
        if (account.isEmpty() || account2.isEmpty() || account.get().getBalance() < amount) {
            return rsl;
        } else {
            double b = account.get().getBalance();
            double d = account2.get().getBalance();
            account2.get().setBalance(amount + d);
            account.get().setBalance(b - amount);
            rsl = true;
        }
        return rsl;
    }
}
