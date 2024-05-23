package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
        //userDaoHibernate.dropUsersTable();
        //userDaoHibernate.createUsersTable();
        User user = userDaoHibernate.getAllUsersById(1);
        System.out.println(user);
        userDaoHibernate.clearUsersTable();




//        List<User> users = userDaoHibernate.getAllUsers();
//        users.forEach(System.out::println);




        //SessionFactory sessionFactory = Util.connectionTest();
////        User user = new User("Успешный","Билли",(byte)12);
//        session.beginTransaction();
////        session.save(user);
////        session.getTransaction().commit();
//        session.close();
//        System.out.println("Коннект прошел");


//        UserServiceImpl userService = new UserServiceImpl();
////        // 5. Удаление таблицы
//        userService.dropUsersTable();
//        System.out.println("1. Создание таблицы User(ов)\n");
//        userService.createUsersTable();
//        System.out.println("2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )");
//        userService.saveUser("Ivan", "Ivanov", (byte) 10);
//        userService.saveUser("Fedor","Fedorov", (byte) 20);
//        userService.saveUser("Maria","Ivanova", (byte) 30);
//        userService.saveUser("Pert","Petrov", (byte) 40);
//        System.out.println("\n+ Удаление User по id");
//        userService.removeUserById(3);
//        System.out.println("\n//3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)");
//        userService.getAllUsers().forEach(System.out::println);
//        System.out.println("\n4. Очистка таблицы User(ов) (работает)");
//        userService.cleanUsersTable();


        //<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        //        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/calculator?autoReconnect=true&amp;useSSL=false</property>
        //        <property name="hibernate.connection.username">root</property>
        //        <property name="hibernate.connection.password">root</property>
        //        <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</p






//        Properties properties = new Properties();
//        properties.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");//J:\CoreTaskTemplate-master\lib\mysql-connector-j-8.3.0.jar
//        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/postgres");
//        properties.setProperty("hibernate.connection.username","postgres");
//        properties.setProperty("hibernate.connection.password","2381012");
//        properties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
//
//       // properties.setProperty("hibernate.hdm2ddl.auto","update");
//
//        //    properties.setProperty("jm.task.core.jdbc.model.User", "update");То что ты мне скидывал, типа поменять import для Entiny - не работает, и
//       // properties.setProperty("show_sql","true");
//        User user = new User("ioan","vas",(byte)12);
//        SessionFactory sessionFactory = new Configuration().addProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//
//
//
//        session.getTransaction().commit();
//        session.close();







//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(User.class);
//        configuration.addProperties(properties);

//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        session.getTransaction();
//        User user = new User("ioan","vas",(byte)12);
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();





        //        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        //        <property name="connection.driver_class">com.mysql.cj.jdbc.Driver</property><!--lib.mysql-connector-j-8.3.0-->
        //        <property name="connection.url">jdbc:mysql://localhost:3306/mysql</property>
        //        <property name="connection.username">root</property>
        //        <property name="connection.password">2381012</property>
        //        <property name="hibernate.show_sql ">true</property>
        //        <property name="jm.task.core.jdbc.util">update</property>
        //        <mapping class="jm.task.core.jdbc.util.Util"/>
    }
}
//public class TestHibernate {
//
//        public static void main(String arg[]) {
//        Properties prop= new Properties();
//
//        prop.setProperty("hibernate.connection.url", "jdbc:mysql://<your-host>:<your-port>/<your-dbname>");
//
//        //You can use any database you want, I had it configured for Postgres
//        prop.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
//
//        prop.setProperty("hibernate.connection.username", "<your-user>");
//        prop.setProperty("hibernate.connection.password", "<your-password>");
//        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        prop.setProperty("show_sql", true); //If you wish to see the generated sql query
//
//    SessionFactory sessionFactory = new Configuration().addProperties(prop).buildSessionFactory();
//       Session session = sessionFactory.openSession();
//    session.beginTransaction();
//            Customer user = new Customer(); //Note customer is a POJO maps to the customer table in the database.
//
//    user.setName("test");
//    user.setisActive(true);
//    session.save(user);
//    session.getTransaction().commit();
//    session.close();
//
//    }
//
//    }
//
//
//@Entity
//@Table(name = "customer", uniqueConstraints = {
//        @UniqueConstraint(columnNames = "customerid")})
//public class Customer implements Serializable{
//
//    private String name;
//    private int customerid;
//    private boolean isActive;
//
//    public Customer() {
//    }
//
//    public Customer(String name, int customerId, boolean isActive) {
//        this.name = name;
//        this.customerid = customerId;
//        this.isActive = isActive;
//    }
//
//    /**
//     *      GETTERS
//     */
//
//    @Column(name = "name", unique = false, nullable = false, length = 100)
//    public String getname() {
//        return name;
//    }
//
//    @Id
//    @GeneratedValue(strategy = IDENTITY)
//    @Column(name = "customerid", unique = true, nullable = false)
//    public int getcustomerid() {
//        return customerid;
//    }
//
//    @Column(name = "isactive", unique = false, nullable = false)
//    public boolean getisactive() {
//        return isActive;
//    }
//
//
//    /**
//     *      SETTERS
//     */
//    public void setname(String name) {
//        this.name = name;
//    }
//
//    public void setisactive(boolean isActive) {
//        this.isActive = isActive;
//    }
//}