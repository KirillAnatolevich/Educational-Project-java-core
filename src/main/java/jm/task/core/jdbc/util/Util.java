package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import java.sql.*;

public class Util implements Cloneable{
    // реализуйте настройку соеденения с БД
    private final String userName = "root";
    private final String password = "2381012";
    private final String connectionURL = "jdbc:mysql://localhost:3306/mysql";
    private final String driverJdbc = "com.mysql.cj.jdbc.Driver";
    private Connection connection;
    Statement statement;
    public void myUpdate(String command) throws ClassNotFoundException, SQLException {
        Class.forName(driverJdbc);
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);statement = connection.createStatement();
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet myQuery(String command) throws ClassNotFoundException, SQLException {
        Class.forName(driverJdbc);
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()){
            return statement.executeQuery(command);
        }
    }



    public void testSetConnectionURL(User user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP DATABASE IF EXISTS d_z2;");
            statement.executeUpdate("CREATE DATABASE d_z2;");
            statement.executeUpdate("USE d_z2;");
            statement.executeUpdate("DROP TABLE IF EXISTS orders; ");
            statement.executeUpdate("CREATE TABLE orders(id INT NOT NULL AUTO_INCREMENT UNIQUE, name VARCHAR(50) NOT NULL UNIQUE, lastName VARCHAR(50) NOT NULL UNIQUE, age INT NOT NULL);");
            statement.executeUpdate("INSERT INTO orders(name, lastName, age)\n" +
                    "VALUES\n" +
                    "('" + user.getName() + "','"+ user.getLastName() + "', " + user.getAge() +");");
            //statement.executeUpdate("DELETE FROM orders WHERE id = 1;");
            User user1 = new User();
            ResultSet resultSet = statement.executeQuery("select * from orders");
            while (resultSet.next()){
                user1.setId((long) resultSet.getInt("id"));
                user1.setName(resultSet.getString("name"));
                user1.setName(resultSet.getString("lastName"));
                user1.setAge((byte) resultSet.getInt("age"));
                System.out.println(user1);
            }
            System.out.println("We re connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
