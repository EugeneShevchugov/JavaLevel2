package com.company.geekbrains.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Task.uniqueWords();
        doDemo();
    }

    private static void doDemo() {
        Map<String, Set<String>> map = new HashMap<>();
        Telephone telephone = new Telephone(map);
        telephone.add("Alan", "89195955737");
        telephone.add("Alan", "88005553535");
        System.out.println(telephone.get("Alan"));
    }
}
