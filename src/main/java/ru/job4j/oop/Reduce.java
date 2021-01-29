package ru.job4j.oop;

public class Reduce {
    private int[] massiv;

    public void to(int[] array) {
        massiv = array;
    }

    public void print() {
        for (int index = 0; index < massiv.length; index++) {
            System.out.println(massiv[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
