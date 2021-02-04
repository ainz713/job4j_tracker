package ru.job4j.poly;

public class Avtobus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус двигается по скоростным трассам");
    }
}
