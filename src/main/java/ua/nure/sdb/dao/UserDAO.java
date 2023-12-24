package ua.nure.sdb.dao;

import ua.nure.sdb.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
