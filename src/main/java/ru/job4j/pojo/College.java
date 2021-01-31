package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Ivanov Ivan Ivanovich");
        student.setGroup("5331");
        student.setData("21.01.2014");
        System.out.println(student.getFio() + System.lineSeparator() +
                student.getGroup() + System.lineSeparator() + student.getData());
    }
}
