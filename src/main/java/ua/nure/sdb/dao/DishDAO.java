package ua.nure.sdb.dao;

import ua.nure.sdb.entity.Dish;

import java.sql.SQLException;
import java.util.List;

public class DishDAO implements DAO<Dish>, Observable{
    @Override
    public List<Dish> get(String id) throws SQLException {
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
    public boolean delete(String Id) throws SQLException {
        return false;
    }

    @Override
    public boolean addAll(List<Dish> t) throws SQLException {
        return false;
    }

    @Override
    public void registerObserver(Observer o) {

    }

    @Override
    public void removeObserver(Observer o) {

    }

    @Override
    public void notifyObservers(String message) {

    }
}
