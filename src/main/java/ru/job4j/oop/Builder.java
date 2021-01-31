package ru.job4j.oop;

public class Builder extends Engineer {
    private String clasbuildera;

    public Builder(String name, String surname, String education, String birthday,
                   String typeofengineer, String clasbuildera) {
        super(name, surname, education, birthday, typeofengineer);
        this.clasbuildera = clasbuildera;
    }

    public String getBuilding() {
        return null;
    }
}
