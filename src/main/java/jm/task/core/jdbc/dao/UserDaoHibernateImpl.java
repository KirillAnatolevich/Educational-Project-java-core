package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        util.startSession();
        util.endSession();
    }

    @Override
    public void dropUsersTable() {
        util.startSession();
        util.getSession().createNativeQuery("DROP TABLE IF EXISTS users", User.class).executeUpdate();
        util.endSession();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        util.startSession();
        util.getSession().save(user);
        util.endSession();
    }

    @Override
    public void removeUserById(long id) {
        util.startSession();
        util.getSession().createQuery("from ", User.class);
        util.endSession();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        util.startSession();
        users = util.getSession().createQuery("from User", User.class).getResultList();
        util.endSession();
        return users;
    }

    public User getAllUsersById(long id) {
        User user = new User();
        util.startSession();
        Query<User> userQuery = util.getSession().createQuery("from User where id = :id", User.class);
        userQuery.setParameter("id", id);
        user = userQuery.getSingleResult();
        util.endSession();
        return user;
    }
    @Override
    public void clearUsersTable() {
        util.startSession();
        util.getSession().createQuery("delete from User").executeUpdate();
        util.endSession();
    }
}
