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
        try {
            util.myUpdate(String.format("CREATE DATABASE %s;", DB_Name.task));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeTaskDatabase(){
        try {
            util.myUpdate(String.format("DROP DATABASE IF EXISTS %s;", DB_Name.task));
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createUsersTable(){
        try {
            util.myUpdate("CREATE TABLE users(id BIGSERIAL NOT NULL PRIMARY KEY UNIQUE, name VARCHAR(50) NOT NULL UNIQUE, lastName VARCHAR(50) NOT NULL UNIQUE, age INT NOT NULL);");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable(){
        try {
            util.myUpdate("DROP TABLE IF EXISTS users;");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age){
        try {
            util.myUpdate("INSERT INTO users(name, lastName, age)\n" +
                    "VALUES\n" +
                    "('" + name + "','"+ lastName + "', " + age +");");
            System.out.printf(" User с именем – %s добавлен в базу данных \n", name);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            util.myUpdate("DELETE FROM users WHERE id = " + id +";");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (ResultSet resultSetCount = util.myQuery("select * from users;");ResultSet resultSet = util.myQuery("select id from users;")){
                    while (resultSetCount.next()) {
                        User user = new User();
                        user.setId((long) resultSetCount.getInt("id"));
                        user.setName(resultSetCount.getString("name"));
                        user.setLastName(resultSetCount.getString("lastName"));
                        user.setAge((byte) resultSetCount.getInt("age"));
                        userList.add(user);
                    }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void clearUsersTable() {
        try {
            util.myUpdate("TRUNCATE users");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void DeleteUsersTable() {
        try {
            util.myUpdate("DELETE FROM users");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
