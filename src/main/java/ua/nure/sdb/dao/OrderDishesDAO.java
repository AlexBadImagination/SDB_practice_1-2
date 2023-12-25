package ua.nure.sdb.dao;

import ua.nure.sdb.entity.OrderDishes;

import java.sql.SQLException;
import java.util.List;

public class OrderDishesDAO implements DAO<OrderDishes>{


    @Override
    public List<OrderDishes> get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDishes> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(OrderDishes orderDishes) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean addAll(List<OrderDishes> t) throws SQLException {
        return false;
    }
}
