package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        int coordinataX = 10;
        int coordinataY = 10;
    }

    @Override
    public void passengers(int numberofpassengers) {
        int allpassengers = numberofpassengers + 1;
    }

    @Override
    public int fill(int fuel) {
        return 0;
    }
}
