package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.DBException;
import ua.nure.sdb.dao.OrderDAO;
import ua.nure.sdb.entity.Dish;
import ua.nure.sdb.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.sdb.dao.mysql.MySqlDAOFactory.getConnection;

public class MySqlOrderDAO extends OrderDAO {
    @Override
    public List<Order> get(long id) throws SQLException {
        try (Connection con = getConnection(false)) {
            try (PreparedStatement st = con.prepareStatement(
                    "select * from `order` where id = ?")) {
                st.setLong(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    List<Order> orders = new ArrayList<>();
                    while (rs.next()) {
                        orders.add(mapOrder(rs));
                    }
                    return orders;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DBException(exception);
        }
    }

    private Order mapOrder(ResultSet rs) throws SQLException{
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setClient(rs.getInt("client"));
        order.setDate(rs.getDate("date"));
        order.setTime(rs.getTime("time"));
        order.setStatus(rs.getInt("status"));
        return order;
    }

    @Override
    public List<Order> getAll() throws SQLException {
        try (Connection con = getConnection(false)) {
            try (Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery("select * from `order`")) {
                    List<Order> orders = new ArrayList<>();
                    while (rs.next()) {
                        orders.add(mapOrder(rs));
                    }
                    return orders;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    @Override
    public boolean add(Order order) throws SQLException {
        Connection con = null;
        try {
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "insert into `order` " +
                            "(id, client, date, time, status) " +
                            "values (?, ?, ?, ?, ?)")) {
                int i = 0;
                st.setLong(++i, order.getId());
                st.setInt(++i, order.getClient());
                st.setDate(++i, order.getDate());
                st.setTime(++i, order.getTime());
                st.setInt(++i, order.getStatus());
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
    public boolean delete(long orderId) throws SQLException {
        Connection con = null;
        try{
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "delete from `order` where id = ?")){
                st.setLong(1, orderId);
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

    @Override
    public List<Order> getReadyOrders() throws SQLException {
        try (Connection con = getConnection(false)) {
            String query = "{CALL GetReadyOrders()}";
            CallableStatement st = con.prepareCall(query);
            try (ResultSet rs = st.executeQuery()) {
                List<Order> orders = new ArrayList<>();
                while (rs.next()) {
                    orders.add(mapOrder(rs));
                }
                return orders;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DBException(exception);
        }
    }
}
