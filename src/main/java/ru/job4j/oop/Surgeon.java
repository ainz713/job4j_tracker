package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String timeofoperation;

    public Surgeon(String name, String surname, String education, String birthday,
                   String specialization, String timeofoperation) {
        super(name, surname, education, birthday, specialization);
        this.timeofoperation = timeofoperation;
    }

    public String getOperation() {
        return null;
    }
}
