package ru.job4j.oop;

public class Max {
    public static int max(int left, int right) {
        int result = left >= right ? left : right;
        return result;
    }

    public static int max(int first, int second, int third) {
        int result = first >= second ? first : second;
        result = result >= third ? result : third;
        return result;
    }

    public static int max(int first, int second, int third, int fourth) {
        int result = first >= second ? first : second;
        result = result >= third ? result : third;
        result = result >= fourth ? result : fourth;
        return result;
    }
}
