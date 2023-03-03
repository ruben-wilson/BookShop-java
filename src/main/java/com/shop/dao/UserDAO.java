package com.shop.dao;

import java.util.List;
import com.shop.models.User;

public interface UserDAO {
  public int addUser(User user);
  
  public User userLogin(String userEmail, String userPassword);

  public List<User> findAllUsers();

  public List<User> findAllUsersByFirstName(String firstName);

  public int updateUserEmailById(int userId, String newEmail);

  public int deleteUserById(int userId);
}