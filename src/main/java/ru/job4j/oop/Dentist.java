package ru.job4j.oop;

public class Dentist extends Doctor {
    private String operationdifficulty;

    public Dentist(String name, String surname, String education, String birthday,
                   String specialization, String operationdifficulty) {
        super(name, surname, education, birthday, specialization);
        this.operationdifficulty = operationdifficulty;
    }

    public String getPacient() {
    }
}
