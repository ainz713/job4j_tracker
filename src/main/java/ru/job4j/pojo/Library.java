package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Nazvanie1", 20);
        Book book2 = new Book("Nazvanie2", 30);
        Book book3 = new Book("Nazvanie3", 40);
        Book book4 = new Book("Clean code", 5);
        Book[] spisok = new Book[4];
        spisok[0] = book1;
        spisok[1] = book2;
        spisok[2] = book3;
        spisok[3] = book4;
        for (int i = 0; i < spisok.length; i++) {
            Book sp = spisok[i];
            System.out.println(sp.getName() + " - " + sp.getStr());
        }
        System.out.println();
        System.out.println("Переставляем местами книги с индексом 0 и 3");
        spisok[0] = book4;
        spisok[3] = book1;
        for (int i = 0; i < spisok.length; i++) {
            Book sp = spisok[i];
            System.out.println(sp.getName() + " - " + sp.getStr());
        }
        System.out.println("Цикл с выводом книг с именем \"Clean code\"");
        for (int i = 0; i < spisok.length; i++) {
            Book sp = spisok[i];
            if (sp.getName().equals("Clean code")) {
                System.out.println(sp.getName() + " - " + sp.getStr());
            }
        }
    }
}
