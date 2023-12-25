package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.DBException;
import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.Order;
import ua.nure.sdb.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.sdb.dao.mysql.MySqlDAOFactory.getConnection;

public class MySqlUserDAO extends UserDAO {
    @Override
    public List<User> get(String id) throws SQLException {
        try (Connection con = getConnection(false)) {
            try (PreparedStatement st = con.prepareStatement(
                    "select * from `user` where id = ?")) {
                st.setString(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    List<User> users = new ArrayList<>();
                    while (rs.next()) {
                        users.add(mapUser(rs));
                    }
                    return users;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DBException(exception);
        }
    }

    private User mapUser(ResultSet rs) throws SQLException{
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setGender(rs.getInt("gender_id"));
        user.setPreferences(rs.getString("preferences"));
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        try (Connection con = getConnection(false)) {
            try (Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery("select * from `user`")) {
                    List<User> users = new ArrayList<>();
                    while (rs.next()) {
                        users.add(mapUser(rs));
                    }
                    return users;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    @Override
    public boolean add(User user) throws SQLException {
        Connection con = null;
        try {
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "insert into `user` " +
                            "(id, name, surname, login, password, gender_id, preferences) " +
                            "values (?, ?, ?, ?, ?, ?, ?)")) {
                int i = 0;
                st.setString(++i, user.getId());
                st.setString(++i, user.getName());
                st.setString(++i, user.getSurname());
                st.setString(++i, user.getLogin());
                st.setString(++i, user.getPassword());
                st.setInt(++i, user.getGender());
                st.setString(++i, user.getPreferences());
                st.execute();
                con.commit();
                return true;
            }
        } catch (SQLException e) {
            MySqlDAOFactory.rollback(con);
            throw new DBException(e);
        } finally {
            MySqlDAOFactory.close(con);
        }
    }

    @Override
    public boolean delete(String userId) throws SQLException {
        Connection con = null;
        try{
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "delete from `user` where id = ?")){
                st.setString(1, userId);
                st.executeUpdate();
                con.commit();
            }
            return true;
        } catch (SQLException e) {
            MySqlDAOFactory.rollback(con);
            throw new DBException(e);
        } finally {
            MySqlDAOFactory.close(con);
        }
    }
}
