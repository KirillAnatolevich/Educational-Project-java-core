package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import org.hibernate.metamodel.MetadataSources;

import java.sql.*;
import java.util.Properties;

public class Util implements Cloneable{
     // реализуйте настройку соеденения с БД
    private final String userName = "postgres";
    private final String password = "2381012";
    private final String connectionURL = "jdbc:postgresql://localhost:5432/postgres";
    private SessionFactory sessionFactory;
    Properties properties = new Properties();
    private Session session;
    public Util() {
    }

    public Session getSession() {
        return session;
    }
    public void startSession(){
        try {
            sessionFactory = new Configuration().addProperties(myProperty()).addAnnotatedClass(User.class).buildSessionFactory();
            session = sessionFactory.openSession();
            session.getTransaction().begin();
        }catch (Exception e){}
    }
    public void endSession(){
        try {
            session.getTransaction().commit();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    private Properties createTableProperty(){
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        return properties;
    }
    private Properties updateTableProperty(){
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
    private Properties myProperty(){
        properties.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty("hibernate.connection.username","postgres");
        properties.setProperty("hibernate.connection.password","2381012");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
        // для распечатки в консоль, и для форматирования
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        // специальное свойство для создания таблиц из Entity, является гибридным, ему можно задать следующие свойства:
        // create - создание таблиц
        // create-drop - будет создавать, и удалять таблицы после завершения сеанса
        // update - обновление существующей схемы данных
        // validate - проверка базы данных
        // none - ни чего не делать
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }

    public void createDataBase() throws ClassNotFoundException, SQLException {
  //      Class.forName(driverJdbc);
        try (Connection  connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP DATABASE IF EXISTS task");
            statement.executeUpdate("CREATE DATABASE task");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void myUpdate(String command) throws ClassNotFoundException, SQLException {
       // Class.forName(driverJdbc);
        try (Connection  connection = DriverManager.getConnection(connectionURL, userName, password); Statement statement = connection.createStatement()){
        //    statement.executeUpdate(String.format("USE %s;", DB_Name.task));
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet myQuery(String command) throws ClassNotFoundException, SQLException {
       // Class.forName(driverJdbc);
        try {
            Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement();
       //     statement.executeUpdate(String.format("USE %s;", DB_Name.task));
            return statement.executeQuery(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
