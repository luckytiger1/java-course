package com.geekbrains.lesson5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
        String[] strArr = {"cat", "dog", "tiger", "table", "table", "cat", "cat", "bird", "elephant", "eagle"};
        showUnique(strArr);
        countValue(strArr);

        HashMap<String, HashSet<String>> hm = new HashMap<>();
        HashSet<String> phones = new HashSet<>();

        phones.add("777115423422");
        phones.add("774323211322");
        phones.add("773211323212");
        hm.put("Martin", phones);

        Phonebook pb = new Phonebook(hm);

        pb.add("Fowler", "28118931298");
        System.out.println(pb.get("Fowler"));
    }

    public static void showUnique(String[] arr) {
        Set<String> unique = new HashSet<>(Arrays.asList(arr));
        System.out.println(unique);
    }

    public static void countValue(String[] arr) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s : arr) {
            hm.put(s, hm.getOrDefault(s,0) + 1);
        }
        System.out.println(hm);
    }
}
