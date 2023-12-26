package ua.nure.sdb.proxy;

import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserProxy implements IUserDAO{
    private boolean isAdmin;
    public UserProxy(int role_id){
       this.isAdmin = role_id == 2;
    }
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
