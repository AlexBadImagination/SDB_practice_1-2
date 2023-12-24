package ua.nure.sdb.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{

    List<T> get(long id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean add(T t) throws SQLException;
    boolean delete(long Id) throws SQLException ;
}
