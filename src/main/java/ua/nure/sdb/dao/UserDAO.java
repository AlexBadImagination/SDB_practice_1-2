package ua.nure.sdb.dao;

import ua.nure.sdb.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements DAO<User>{
    @Override
    public List<User> get(long id) throws SQLException {
        return null;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(User user) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(long Id) throws SQLException {
        return false;
    }

    public User getLoginPassword(String login, String password) throws SQLException {
        return null;
    }

}
