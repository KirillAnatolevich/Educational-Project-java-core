package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jm.task.core.jdbc.util.DB_Name;
import jm.task.core.jdbc.util.Util;
public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    public void createTaskDatabase(){
    }
    public void removeTaskDatabase(){
    }

    public void createUsersTable(){
    }

    public void dropUsersTable(){
    }

    public void saveUser(String name, String lastName, byte age){
    }

    public void removeUserById(long id) {
    }
        public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        return userList;
    }

    public void clearUsersTable() {
    }

    public void DeleteUsersTable() {
    }
}
