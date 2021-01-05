package com.geekbrains.lesson5;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> phoneSurname;

    public Phonebook(HashMap<String, HashSet<String>> phoneSurname) {
        this.phoneSurname = phoneSurname;
    }

    public void add(String surname, String phone) {
        phoneSurname.putIfAbsent(surname, new HashSet<>());
        phoneSurname.get(surname).add(phone);
    }

    public HashSet<String> get(String surname) {
        return phoneSurname.get(surname);
    }
}
