package ua.nure.sdb.dao;

import ua.nure.sdb.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDAO implements DAO<Order>{
    @Override
    public List<Order> get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean addAll(List<Order> t) throws SQLException {
        return false;
    }

    public List<Order> getReadyOrders() throws SQLException {
        return null;
    }
}
