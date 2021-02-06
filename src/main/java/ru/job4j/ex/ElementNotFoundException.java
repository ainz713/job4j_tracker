package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] != key && value[i] == value[value.length - 1]) {
                throw new ElementNotFoundException();
            } else if (value[i] == key) {
                rsl = i;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"vasya", "petya", null, null};
        try {
            System.out.println(indexOf(value, "masha"));
        } catch (ElementNotFoundException e) {
           e.printStackTrace();
        }
    }
}
