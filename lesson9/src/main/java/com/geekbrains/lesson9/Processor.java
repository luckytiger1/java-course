package com.geekbrains.lesson9;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Processor {

    private static Connection connection;
    private static Statement statement;

    public static void buildTable(Class<?> className) throws SQLException {
        if (className.isAnnotationPresent(Table.class)) {
            Map<Class<?>, String> map = new HashMap<>();
            map.put(int.class, "INTEGER");
            map.put(String.class, "TEXT");
            StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
            sb.append(className.getAnnotation(Table.class).title());
            sb.append(" (");
            Field[] fields = className.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    sb.append(field.getName())
                            .append(" ")
                            .append(map.get(field.getType()))
                            .append(", ");
                }
            }
            sb.setLength(sb.length() - 2);
            sb.append(");");
            statement.executeUpdate(sb.toString());
        } else {
            throw new RuntimeException("@Table missing");
        }

    }

    public static void connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/lesson9");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public static void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
