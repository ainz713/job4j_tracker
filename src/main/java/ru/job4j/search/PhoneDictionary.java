package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */

    public ArrayList<Person> find(String key) {
       Predicate<Person> first = x -> x.getName().contains(key);
        Predicate<Person> second = t -> t.getSurname().contains(key);
        Predicate<Person> third = c -> c.getPhone().contains(key);
        Predicate<Person> fourth = g -> g.getAddress().contains(key);
        Predicate<Person> combine = first.or(second).or(third).or(fourth);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    }

