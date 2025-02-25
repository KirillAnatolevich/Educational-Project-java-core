package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }
    public void createTaskDatabase(){
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createTaskDatabase();
    }
    public void removeTaskDatabase(){
        userDaoJDBC.removeTaskDatabase();
    }

    public void dropUsersTable() {
        userDaoHibernate.clearUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoHibernate.getAllUsers();//
    }

    public void cleanUsersTable() {
        userDaoHibernate.clearUsersTable();
    }
    public void DeleteUsersTable() {
        userDaoJDBC.DeleteUsersTable();
    }
}
