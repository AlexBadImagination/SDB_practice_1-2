package ua.nure.sdb.proxy;

import ua.nure.sdb.dao.DAOFactory;
import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.User;

import java.sql.SQLException;

public class WebSite {
    public static void main(String[] args){
        DBProxy dbProxy = new DBProxy("qriabchenko", "b9FzqiDa)O");
        try {
            System.out.println(dbProxy.add(
                    new User.Builder()
                            .withId(3)
                            .withName("Дмитро")
                            .withSurname("Карпенко")
                            .withLogin("dmitriy124")
                            .withPassword("StrongPassword1234")
                            .withGender(1)
                            .withPreferences("Якийсь текст")
                            .build()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
