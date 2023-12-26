package ua.nure.sdb.dao;

import ua.nure.sdb.dao.MongoDB.MongoDBFactory;
import ua.nure.sdb.dao.mysql.MySqlDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory(boolean MySQL) {
        if(MySQL)
            return MySqlDAOFactory.getMySqlDAOFactory();
        return MongoDBFactory.getMongoDBFactory();
    }

    public abstract UserDAO getUserDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract DishDAO getDishDAO();
    public abstract OrderDishesDAO getOrderDishesDAO();
}

