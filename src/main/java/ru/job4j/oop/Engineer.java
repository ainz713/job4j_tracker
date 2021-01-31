package ru.job4j.oop;

public class Engineer extends Profession {
    private String typeofengineer;

    public Engineer(String name, String surname, String education, String birthday,
                    String typeofengineer) {
        super(name, surname, education, birthday);
        this.typeofengineer = typeofengineer;
    }

    public String getTypeofengineer() {
        return null;
    }
}
