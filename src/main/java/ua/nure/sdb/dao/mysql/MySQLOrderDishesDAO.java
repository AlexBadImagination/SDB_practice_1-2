package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.DBException;
import ua.nure.sdb.dao.OrderDishesDAO;
import ua.nure.sdb.entity.OrderDishes;
import ua.nure.sdb.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.sdb.dao.mysql.MySqlDAOFactory.getConnection;

public class MySQLOrderDishesDAO extends OrderDishesDAO {

    @Override
    public List<OrderDishes> get(String id) throws SQLException {
        try (Connection con = getConnection(false)) {
            try (PreparedStatement st = con.prepareStatement(
                    "select * from `order_dishes` where `order` = ?")) {
                st.setString(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    List<OrderDishes> orderDishes = new ArrayList<>();
                    while (rs.next()) {
                        orderDishes.add(mapOrderDishes(rs));
                    }
                    return orderDishes;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DBException(exception);
        }
    }

    private OrderDishes mapOrderDishes(ResultSet rs) throws SQLException{
        OrderDishes orderDishes = new OrderDishes();
        orderDishes.setOrder(rs.getString("order"));
        orderDishes.setDish(rs.getString("dish"));
        orderDishes.setAmount(rs.getInt("amount"));
        orderDishes.setPriority(rs.getInt("priority"));
        return orderDishes;
    }

    @Override
    public List<OrderDishes> getAll() throws SQLException {
        try (Connection con = getConnection(false)) {
            try (Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery("select * from `order_dishes`")) {
                    List<OrderDishes> orderDishes = new ArrayList<>();
                    while (rs.next()) {
                        orderDishes.add(mapOrderDishes(rs));
                    }
                    return orderDishes;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    @Override
    public boolean add(OrderDishes orderDishes) throws SQLException {
        Connection con = null;
        try {
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "insert into `order_dishes` " +
                            "(`order`, dish, amount, priority) " +
                            "values (?, ?, ?, ?)")) {
                int i = 0;
                st.setString(++i, orderDishes.getOrder());
                st.setString(++i, orderDishes.getDish());
                st.setInt(++i, orderDishes.getAmount());
                st.setInt(++i, orderDishes.getPriority());
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
    public boolean delete(String orderId) throws SQLException {
        Connection con = null;
        try{
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "delete from `order_dishes` where `order` = ?")){
                st.setString(1, orderId);
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
