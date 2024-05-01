package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import java.sql.*;

public class Util implements Cloneable{
    // реализуйте настройку соеденения с БД
    private final String userName = "root";
    private final String password = "2381012";
    private final String connectionURL = "jdbc:mysql://localhost:3306/mysql";
    private final String driverJdbc = "com.mysql.cj.jdbc.Driver";
    public void myUpdate(String command) throws ClassNotFoundException, SQLException {
        Class.forName(driverJdbc);
        try (Connection  connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()){
            statement.executeUpdate(String.format("USE %s;", DB_Name.task));
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet myQuery(String command) throws ClassNotFoundException, SQLException {
        Class.forName(driverJdbc);
        try {
            Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("USE %s;", DB_Name.task));
            return statement.executeQuery(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
