/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.UserDao;
import com.mycompany.project_alpabet_crud.model.User;
import java.util.List;

/**
 *
 * @author PanisaraS
 */
public class UserService {

    public static User currentUser;

    public User login(String login, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.getByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            return user;
        }
        return null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public List<User> getUsers() {
        UserDao userDao = new UserDao();
        return userDao.getAll(" user_login asc");
    }

    public User addNew(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.save(editedUser);
    }

    public User update(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.update(editedUser);
    }

    public int delete(User editedUser) {
        UserDao userDao = new UserDao();
        return userDao.delete(editedUser);
    }
}
