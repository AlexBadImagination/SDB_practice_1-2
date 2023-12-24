package ua.nure.sdb.dao;

import ua.nure.sdb.dao.mysql.MySqlDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory() {

        // read configuration
        return MySqlDAOFactory.getMySqlDAOFactory();
    }

    public abstract UserDAO getUserDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract DishDAO getDishDAO();
    public abstract OrderDishesDAO getOrderDishesDAO();
}

