package ua.nure.sdb;

import ua.nure.sdb.dao.*;
import ua.nure.sdb.dao.MongoDB.MongoDBFactory;
import ua.nure.sdb.dao.mysql.Client;
import ua.nure.sdb.entity.Dish;
import ua.nure.sdb.entity.Order;
import ua.nure.sdb.entity.OrderDishes;
import ua.nure.sdb.entity.User;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        //mySQLMain();
        mongoDBMain();

        /*DAOFactory mySQLDaoFactory = DAOFactory.getDAOFactory(true);
        DAOFactory mongoDBFactory = DAOFactory.getDAOFactory(false);

        UserDAO mysqlUserDAO = mySQLDaoFactory.getUserDAO();
        UserDAO mongoUserDAO = mongoDBFactory.getUserDAO();
        try{
            transferToMySQL(mysqlUserDAO, mongoUserDAO);
            transferToMySQL(mysqlUserDAO, mongoUserDAO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }
    public static boolean transferToMongoDB(UserDAO mysqlUserDAO, UserDAO mongoUserDAO) throws SQLException {
        List<User> users = mysqlUserDAO.getAll();
        System.out.println(users.toString());
        for (int i = 0; i < users.size(); i++){
            mongoUserDAO.add(users.get(i));
        }
        System.out.println(mysqlUserDAO.getAll());
        return true;
    }
    public static boolean transferToMySQL(UserDAO mysqlUserDAO, UserDAO mongoUserDAO) throws SQLException {
        List<User> users = mongoUserDAO.getAll();
        System.out.println(users.toString());
        for (int i = 0; i < users.size(); i++){
            mysqlUserDAO.add(users.get(i));
        }
        System.out.println(mongoUserDAO.getAll());
        return true;
    }

    public static void mySQLMain(){

        DAOFactory df = DAOFactory.getDAOFactory(true);
        DAOFactory newDf = DAOFactory.getDAOFactory(true);
        System.out.println("Are the dao factories same?");
        System.out.println(df == newDf);
        DishDAO dishDAO = df.getDishDAO();
        newDf.getDishDAO();
        OrderDAO orderDAO = df.getOrderDAO();
        UserDAO userDAO = df.getUserDAO();
        OrderDishesDAO orderDishesDAO = df.getOrderDishesDAO();
        Client client = new Client();
        dishDAO.registerObserver(client);

        try {
            System.out.println(dishDAO.delete("1"));
            System.out.println(orderDAO.delete("1"));
            System.out.println(orderDAO.delete("2"));
            System.out.println(orderDAO.delete("3"));
            System.out.println(userDAO.delete("1"));
            Dish dish = new Dish.Builder()
                    .withId("1")
                    .withName("Український суп")
                    .withPrice(120.58f)
                    .withWeight(400)
                    .withCategory(1)
                    .withDescription(null)
                    .build();
            System.out.println(dishDAO.add(dish));
            System.out.println(dishDAO.get("1"));
            dishDAO.getAll().forEach(System.out::println);
            System.out.println(dishDAO.delete("1"));
            dishDAO.getAll().forEach(System.out::println);
            System.out.println(dishDAO.add(dish));
            System.out.println();

            User user = new User.Builder()
                    .withId("1")
                    .withName("Дмитро")
                    .withSurname("Карпенко")
                    .withLogin("dmitriy124")
                    .withPassword("StrongPassword1234")
                    .withGender(1)
                    .withPreferences("Якийсь текст")
                    .build();
            System.out.println(userDAO.add(user));
            System.out.println(userDAO.get("1"));
            userDAO.getAll().forEach(System.out::println);
            System.out.println(userDAO.delete("1"));
            userDAO.getAll().forEach(System.out::println);
            System.out.println(userDAO.add(user));
            System.out.println();

            Order order1 = new Order.Builder()
                    .withId("1")
                    .withClient(1)
                    .withDate(new Date(123, 11,25))
                    .withTime(new Time(11,59,59))
                    .withStatus(3)
                    .build();

            Order order2 = new Order.Builder()
                    .withId("2")
                    .withClient(1)
                    .withDate(new Date(123, 11,17))
                    .withTime(new Time(11,59,59))
                    .withStatus(3)
                    .build();

            Order order3 = new Order.Builder()
                    .withId("3")
                    .withClient(1)
                    .withDate(new Date(123, 11,17))
                    .withTime(new Time(11,05,36))
                    .withStatus(3)
                    .build();

            System.out.println(orderDAO.add(order1));
            System.out.println(orderDAO.add(order2));
            System.out.println(orderDAO.add(order3));
            System.out.println(orderDAO.get("1"));
            orderDAO.getAll().forEach(System.out::println);
            System.out.println(orderDAO.delete("1"));
            orderDAO.getAll().forEach(System.out::println);
            System.out.println(orderDAO.add(order1));
            System.out.println();

            OrderDishes orderDishes = new OrderDishes.Builder()
                    .withOrder("1")
                    .withDish("1")
                    .withAmount(2)
                    .withPriority(1)
                    .build();

            System.out.println(orderDishesDAO.add(orderDishes));
            System.out.println(orderDishesDAO.get("1"));
            orderDishesDAO.getAll().forEach(System.out::println);
            System.out.println(orderDishesDAO.delete("1"));
            orderDishesDAO.getAll().forEach(System.out::println);
            System.out.println();

            orderDAO.getReadyOrders().forEach((x) -> System.out.println("Order # " + x.getId() + ", date: " + x.getDate()));

            System.out.println();
//            System.out.println(dishDAO.delete("1"));
//            System.out.println(orderDAO.delete("1"));
//            System.out.println(orderDAO.delete("2"));
//            System.out.println(orderDAO.delete("3"));
//            System.out.println(userDAO.delete("1"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mongoDBMain(){
        DAOFactory mongoDBFactory = DAOFactory.getDAOFactory(false);
        UserDAO userDAO = mongoDBFactory.getUserDAO();
        try{
//            System.out.println("User:");
//            System.out.println(userDAO.get("1"));
//            System.out.println();
//            User user = new User.Builder()
//                    .withId("1")
//                    .withName("Petya")
//                    .withSurname("Ershov")
//                    .withLogin("petyaershov")
//                    .withPassword("strongpassword15132")
//                    .withGender(1)
//                    .build();
//            System.out.println(userDAO.add(user));
//            System.out.println();
//            System.out.println(userDAO.getAll());
//            System.out.println("End");
            int[] amounts = new int[]{1, 10, 100, 1000, 10000, 50000, 100000, 500000};
            long m = System.currentTimeMillis();
            //for (int i = 0; i < 100000; i++){
                insertManyUsers(userDAO, 10000);
                System.out.print("Added " + 10000 + " documents in ");
                System.out.print((double) (System.currentTimeMillis() - m));
                System.out.print(" milliseconds");
            //}
            System.out.println(userDAO.delete("g"));
        }catch (SQLException e){
            System.out.println("There was an error");
        }
    }

    public static void insertManyUsers(UserDAO userDAO, int amount) throws SQLException {
        List<User> users = new ArrayList<>();
        User user = new User.Builder()
                .withName("Petya")
                .withSurname("Ershov")
                .withLogin("petyaershov")
                .withPassword("strongpassword15132")
                .withGender(1)
                .build();
        for (int i = 0; i < amount; i++){
            user.setId("" + i);
            users.add(user);
        }
        userDAO.addAll(users);
    }

}
