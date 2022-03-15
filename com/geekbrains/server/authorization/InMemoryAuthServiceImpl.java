package com.geekbrains.server.authorization;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAuthServiceImpl implements AuthService {
  //  private final Map<String, UserData> users;


    public InMemoryAuthServiceImpl() {
//        users = new HashMap<>();
//        users.put("login1", new UserData("login1", "password1", "first_user"));
//        users.put("login2", new UserData("login2", "password2", "second_user"));
//        users.put("login3", new UserData("login3", "password3", "third_user"));
    }



    @Override
    public void start() {
        System.out.println("Сервис аутентификации инициализирован");
    }

    @Override
    public synchronized String getNickNameByLoginAndPassword(String login, String password) throws Exception {
        JdbcConnector.connection();
      return JdbcConnector.logIn(login,password);
    }

    @Override
    public void end() {
        System.out.println("Сервис аутентификации отключен");
    }
}
