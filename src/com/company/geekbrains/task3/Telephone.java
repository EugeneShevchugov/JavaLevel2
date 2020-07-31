package com.company.geekbrains.task3;

import java.util.*;

public class Telephone {
    private Map<String, Set<String>> info;

    public Telephone(Map<String, Set<String>> info) {
        this.info = info;
    }

    public void add(String surname, String number) {
        if (!info.containsKey(surname)) {
            info.put(surname, new HashSet<>());
        }
        info.get(surname).add(number);
    }

    public List<String> get(String surname) {
        if (!info.containsKey(surname)) {
            return null;
        }
        return new ArrayList<>(info.get(surname));
    }
}
