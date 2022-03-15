package com.geekbrains.server.authorization;

import java.sql.*;

public class JdbcConnector {
    private static Connection connection;
    private static Statement statement;

    public static void connection() throws Exception {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            disconnect();
        }

    }

    private static void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:users.db");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String logIn(String login, String password) throws SQLException {
        try (ResultSet logIN = statement.executeQuery("SELECT FROM USERS;")) {
            while (logIN.next()) {
                if (login.equals(logIN.getString("login"))) {
                    String user = logIN.getString("nickName");
                    if (password.equals(statement.execute("password"))) {
                        return user;
                    }
                }
            }
        }
        return null;
    }


}
