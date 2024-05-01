package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

// Алгоритм работы приложения:
//         В методе main класса Main должны происходить следующие операции:
//1. Создание таблицы User(ов)
//2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
//3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
//4. Очистка таблицы User(ов)
//5. Удаление таблицы
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        User user = new User();

        Util util = new Util();

        userService.removeTaskDatabase();
        userService.createTaskDatabase();
        userService.connectTaskDatabase();
        //userService.createUsersTable();

//        util.myUpdate("DROP DATABASE IF EXISTS d_z1;");
//        util.myUpdate("CREATE DATABASE d_z1;");
//        util.myUpdate("USE d_z1;");
     //   util.myUpdate("DROP TABLE IF EXISTS users;");
        //       util.myUpdate("CREATE TABLE users(id INT NOT NULL AUTO_INCREMENT UNIQUE, name VARCHAR(50) NOT NULL UNIQUE, lastName VARCHAR(50) NOT NULL UNIQUE, age INT NOT NULL);");


        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Ivan", "Ivanov", (byte) 10);
        userService.saveUser("Fedor","Fedorov", (byte) 20);
        userService.saveUser("Maria","Ivanova", (byte) 30);
        userService.saveUser("Pert","Petrov", (byte) 40);


//        List<User> userList =
//        userList.forEach(System.out::println);

//        Util util = new Util();
//        User user = new User("Max","Butus", (byte) 12);
//        util.testSetConnectionURL(user);

    }
}
