package com.company.geekbrains.task3;

import java.util.*;

public class Task {
    public static void uniqueWords() {
        String[] words = {"Apple", "Apple", "Banana", "Apricot", "Grape", "Juice", "Cherry", "Orange", "Vine", "Peach",
                "Grape", "Ball", "Picture", "Dress", "Science", "Computer", "NoteBook", "Apple", "Juice", "Vine"};
        Set<String> strings = new HashSet<>(Arrays.asList(words));
        System.out.println(String.format("Количество уникальных слов = %d", strings.size()));

        List<String> storage = new ArrayList<>();
        info(storage, words);
        String[] wordsFromSet = new String[strings.size()];
        wordsFromSet = strings.toArray(wordsFromSet);
        info(storage, wordsFromSet);
    }

    private static void info(List<String> storage, String[] words) {
        for (String word : words) {
            if (storage.contains(word)) {
                continue;
            } else {
                System.out.println(String.format("%s встретилось %d раз", word, countSameWords(words, word)));
                storage.add(word);
            }
        }
        System.out.println();
        storage.clear();
    }

    private static int countSameWords(String[] words, String word) {
        int count = 0;
        for (String s : words) {
            if (s.equals(word)) {
                count++;
            }
        }
        return count;
    }
}
