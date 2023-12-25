package ua.nure.sdb.dao.mysql;

import ua.nure.sdb.dao.Observer;

public class Client implements Observer {
    @Override
    public void update(String message) {
        System.out.println(message);
    }
}
