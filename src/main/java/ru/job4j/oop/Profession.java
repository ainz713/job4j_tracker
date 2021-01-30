package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public String getName() {
    }

    public String getSurname() {
    }

    public String getEducation() {
    }

    public String getBirthday() {
    }
}

public class Engineer extends Profession {
    private String typeofengineer;
}

public class Doctor extends Profession {
    private String specialization;
}

public class Surgeon extends Doctor {
    private String timeofoperation;
    public String getOperation() {
    }
}

public class Dentist extends Doctor {
    private String operationdifficulty;
    public String getPacient() {
    }
}

public class Programmer extends Engineer {
    private String langofprogramming;
    public String getProject() {
    }
}

public class Builder extends Engineer {
    private String clasbuildera;
    public String getBuilding() {
    }
}