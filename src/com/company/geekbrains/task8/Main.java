package com.company.geekbrains.task8;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        OneLinkedList names = new OneLinkedList();
        names.add("Mike");
        names.add("Bob");
        names.add("Fred");
        names.add("Jorge");
        System.out.println(names.toString());
        OneLinkedList.Iterator iterator = names.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
