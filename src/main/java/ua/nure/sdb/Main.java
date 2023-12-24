package ua.nure.sdb;

import ua.nure.sdb.dao.*;
import ua.nure.sdb.entity.Dish;
import ua.nure.sdb.entity.Order;
import ua.nure.sdb.entity.OrderDishes;
import ua.nure.sdb.entity.User;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;


public class Main {
    public static void main(String[] args){
        DAOFactory df = DAOFactory.getDAOFactory();
        DAOFactory newDf = DAOFactory.getDAOFactory();
        System.out.println("Are the dao factories same?");
        System.out.println(df == newDf);
        DishDAO dishDAO = df.getDishDAO();
        newDf.getDishDAO();
        OrderDAO orderDAO = df.getOrderDAO();
        UserDAO userDAO = df.getUserDAO();
        OrderDishesDAO orderDishesDAO = df.getOrderDishesDAO();

        try {
            System.out.println(dishDAO.add(new Dish(1, "Український суп", 120.58f, 400, null, 1)));
            System.out.println(dishDAO.get(1));
            dishDAO.getAll().forEach(System.out::println);
            System.out.println(dishDAO.delete(1));
            dishDAO.getAll().forEach(System.out::println);
            System.out.println(dishDAO.add(new Dish(1, "Український суп", 120.58f, 400, null, 1)));
            System.out.println();

            System.out.println(userDAO.add(new User(1, "Дмитро", "Карпенко", "dmitriy124", "StrongPassword1234", 1, "Якийсь текст")));
            System.out.println(userDAO.get(1));
            userDAO.getAll().forEach(System.out::println);
            System.out.println(userDAO.delete(1));
            userDAO.getAll().forEach(System.out::println);
            System.out.println(userDAO.add(new User(1, "Дмитро", "Карпенко", "dmitriy124", "StrongPassword1234", 1, "Якийсь текст")));
            System.out.println();

            System.out.println(orderDAO.add(new Order(1, 1, new Date(123, 11,25), new Time(11,59,59), 3)));
            System.out.println(orderDAO.add(new Order(2, 1, new Date(123, 11,17), new Time(11,59,59), 3)));
            System.out.println(orderDAO.add(new Order(3, 1, new Date(123, 11,17), new Time(11,05,36), 3)));
            System.out.println(orderDAO.get(1));
            orderDAO.getAll().forEach(System.out::println);
            System.out.println(orderDAO.delete(1));
            orderDAO.getAll().forEach(System.out::println);
            System.out.println(orderDAO.add(new Order(1, 1, new Date(123, 11,25), new Time(11,59,59), 3)));
            System.out.println();

            System.out.println(orderDishesDAO.add(new OrderDishes(1, 1, 2, 1)));
            System.out.println(orderDishesDAO.get(1));
            orderDishesDAO.getAll().forEach(System.out::println);
            System.out.println(orderDishesDAO.delete(1));
            orderDishesDAO.getAll().forEach(System.out::println);
            System.out.println();

            orderDAO.getReadyOrders().forEach((x) -> System.out.println("Order # " + x.getId() + ", date: " + x.getDate()));

            System.out.println();
            System.out.println(dishDAO.delete(1));
            System.out.println(orderDAO.delete(1));
            System.out.println(orderDAO.delete(2));
            System.out.println(orderDAO.delete(3));
            System.out.println(userDAO.delete(1));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
