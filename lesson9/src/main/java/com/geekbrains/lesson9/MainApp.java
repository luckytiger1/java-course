package com.geekbrains.lesson9;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) {
        try {
            Processor.connect();
            Processor.buildTable(Cat.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Processor.disconnect();
        }
    }
}
