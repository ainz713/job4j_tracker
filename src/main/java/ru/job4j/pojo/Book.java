package ru.job4j.pojo;

public class Book {
    private String name;
    private int str;

    public Book(String name, int str) {
        this.name = name;
        this.str = str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }
}
