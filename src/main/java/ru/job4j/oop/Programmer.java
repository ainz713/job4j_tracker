package ru.job4j.oop;

public class Programmer extends Engineer {
    private String langofprogramming;

    public Programmer(String name, String surname, String education, String birthday,
                      String typeofengineer, String langofprogramming) {
        super(name, surname, education, birthday, typeofengineer);
        this.langofprogramming = langofprogramming;
    }

    public String getProject() {
        return null;
    }
}
