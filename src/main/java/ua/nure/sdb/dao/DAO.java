package ua.nure.sdb.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{

    List<T> get(String id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean add(T t) throws SQLException;
    boolean delete(String Id) throws SQLException ;
    boolean addAll(List<T> t) throws SQLException;
}
