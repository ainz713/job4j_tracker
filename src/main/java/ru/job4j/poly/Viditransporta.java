package ru.job4j.poly;

public class Viditransporta {
    public static void main(String[] args) {
        Vehicle samolet = new Samolet();
        Vehicle poezd = new Poezd();
        Vehicle avtobus = new Avtobus();
        Vehicle[] massiv = new Vehicle[]{samolet, poezd, avtobus};
        for (Vehicle v:massiv) {
            v.move();
        }
    }
}
