package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class Main {
    public static void main(String[] args){
        // реализуйте алгоритм здесь
        String name = "Меткий";
        String lastName = "Фредди";
        byte age = 35;
        String name2 = "Успешный";
        String lastName2 = "Билли";
        byte age2 = 22;

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name2, lastName2, age2);
        List<User> users = userDaoHibernate.getAllUsers();
        users.forEach(System.out::println);
        User user = userDaoHibernate.getAllUsersById(1);
        System.out.println(user);
        userDaoHibernate.clearUsersTable();

    }
}
