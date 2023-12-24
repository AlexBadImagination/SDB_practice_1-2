package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.DBException;
import ua.nure.sdb.dao.DishDAO;
import ua.nure.sdb.entity.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.nure.sdb.dao.mysql.MySqlDAOFactory.getConnection;

public class MySqlDishDAO extends DishDAO {
    @Override
    public List<Dish> get(long id) throws SQLException {
        try (Connection con = getConnection(false)) {
            try (PreparedStatement st = con.prepareStatement(
                    "select * from dish where id = ?")) {
                st.setLong(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    List<Dish> dishes = new ArrayList<>();
                    while (rs.next()) {
                        dishes.add(mapDish(rs));
                    }
                    return dishes;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new DBException(exception);
        }
    }

    private Dish mapDish(ResultSet rs) throws SQLException{
        Dish dish = new Dish();
        dish.setId(rs.getInt("id"));
        dish.setName(rs.getString("name"));
        dish.setPrice(rs.getFloat("price"));
        dish.setWeight(rs.getInt("weight"));
        dish.setDescription(rs.getString("description"));
        dish.setCategory(rs.getInt("category"));
        return dish;
    }

    @Override
    public List<Dish> getAll() throws SQLException {
        try (Connection con = getConnection(false)) {
            try (Statement st = con.createStatement()) {
                try (ResultSet rs = st.executeQuery("select * from dish")) {
                    List<Dish> dish = new ArrayList<>();
                    while (rs.next()) {
                        dish.add(mapDish(rs));
                    }
                    return dish;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DBException(e);
        }
    }

    @Override
    public boolean add(Dish dish) throws SQLException {
        Connection con = null;
        try {
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "insert into dish " +
                            "(id, name, price, weight, description, category) " +
                            "values (?, ?, ?, ?, ?, ?)")) {
                int i = 0;
                st.setLong(++i, dish.getId());
                st.setString(++i, dish.getName());
                st.setFloat(++i, dish.getPrice());
                st.setInt(++i, dish.getWeight());
                st.setString(++i, dish.getDescription());
                st.setInt(++i, dish.getCategory());
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
    public boolean delete(long dishId) throws SQLException {
        Connection con = null;
        try{
            con = getConnection(false);
            try (PreparedStatement st = con.prepareStatement(
                    "delete from dish where id = ?")){
                st.setLong(1, dishId);
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
