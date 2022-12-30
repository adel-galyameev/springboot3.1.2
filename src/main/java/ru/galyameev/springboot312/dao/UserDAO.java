package ru.galyameev.springboot312.dao;


import ru.galyameev.springboot312.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> listUsers();
    public void save (User user);
    public User getUser(int id);
    public void update (User user);
    public void delete(int id);


}
