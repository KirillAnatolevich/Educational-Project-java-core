package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public class Util implements Cloneable{
     // реализуйте настройку соеденения с БД
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
        }catch (Exception e){e.printStackTrace();}
    }
    public void endSession(){
        try {
            session.getTransaction().commit();
        }catch (Exception e){e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
    private Properties myProperty(){
        properties.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty("hibernate.connection.username","postgres");
        properties.setProperty("hibernate.connection.password","2381012");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");

        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        return properties;
    }
}
