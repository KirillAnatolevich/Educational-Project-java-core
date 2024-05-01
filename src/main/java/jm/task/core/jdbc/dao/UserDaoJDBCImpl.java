package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jm.task.core.jdbc.util.Util;
public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    public void createTaskDatabase(){
        try {
            util.myUpdate("CREATE DATABASE task;");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeTaskDatabase(){
        try {
            util.myUpdate("DROP DATABASE IF EXISTS task;");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void connectTaskDatabase(){
        try {
            util.myUpdate("USE task;");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void createUsersTable(){
        try {
            util.myUpdate("CREATE TABLE users(id INT NOT NULL AUTO_INCREMENT UNIQUE, name VARCHAR(50) NOT NULL UNIQUE, lastName VARCHAR(50) NOT NULL UNIQUE, age INT NOT NULL);");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable(){
        try {
            util.myUpdate("DROP TABLE IF EXISTS users;");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age){
        try {
            util.myUpdate("INSERT INTO users(name, lastName, age)\n" +
                    "VALUES\n" +
                    "('" + name + "','"+ lastName + "', " + age +");");
            System.out.printf(" User с именем – %s добавлен в базу данных \n", name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try {
            util.myUpdate("DELETE FROM users WHERE id = " + id +";");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            ResultSet resultSet = util.myQuery("SELECT COUNT(*) FROM users;");//util.myUpdate("SELECT COUNT(*) FROM users");//: SELECT COUNT (*). FROM table_name
            int size = resultSet.getInt(1);

            System.out.println(size);
//            ResultSet resultSet = util.myQuery("select * from users");
//            while (resultSet.next()){
//                User user = new User();
//                user.setId((long) resultSet.getInt("id"));
//                user.setName(resultSet.getString("name"));
//                user.setName(resultSet.getString("lastName"));
//                user.setAge((byte) resultSet.getInt("age"));
//                userList.add(user);
//
//            }

        } catch (ClassNotFoundException  e) {//| SQLException
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public void getAllUserById() {


    }

    public void clearUsersTable() {
        try {
            util.myUpdate("DELETE FROM users");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
