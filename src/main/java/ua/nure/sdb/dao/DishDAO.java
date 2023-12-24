package ua.nure.sdb.dao;

import ua.nure.sdb.entity.Dish;

import java.sql.SQLException;
import java.util.List;

public class DishDAO implements DAO<Dish>{
    @Override
    public List<Dish> get(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Dish> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(Dish dish) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(long Id) throws SQLException {
        return false;
    }
}
