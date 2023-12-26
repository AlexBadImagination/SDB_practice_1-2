package ua.nure.sdb.proxy;

import ua.nure.sdb.dao.DAOFactory;
import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.User;

import java.sql.SQLException;
import java.util.List;

public class DBProxy extends UserDAO{
    UserDAO userDAO;
    boolean isAdmin;
    public DBProxy(String login, String password){
        userDAO = DAOFactory.getDAOFactory().getUserDAO();
        isAdmin = checkAccess(login, password);
    }

    public boolean checkAccess(String login, String password){
        try {
            User user = userDAO.getLoginPassword(login, password);
            if (user == null){
                return false;
            }
            if (user.getRole() == 2)
                return true;
        } catch (SQLException e) {

        }
        return false;
    }

    @Override
    public List<User> get(long id) throws SQLException {
        return userDAO.get(id);
    }

    @Override
    public List<User> getAll() throws SQLException {
        return userDAO.getAll();
    }

    @Override
    public boolean add(User user) throws SQLException {
        if (isAdmin){
            userDAO.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long userId) throws SQLException {
        if (isAdmin){
            userDAO.delete(userId);
            return true;
        }
        return false;
    }
}
