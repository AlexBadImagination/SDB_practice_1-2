package ua.nure.sdb;

import ua.nure.sdb.dao.DAOFactory;
import ua.nure.sdb.dao.MongoDB.MongoDBFactory;
import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainMongoDb {
    public static void main(String[] args){
        DAOFactory mongoDBFactory = new MongoDBFactory();
        UserDAO userDAO = mongoDBFactory.getUserDAO();
        try{
            System.out.println("User:");
            System.out.println(userDAO.get("1"));
            System.out.println();
            User user = new User.Builder()
                    .withId("1")
                    .withName("Petya")
                    .withSurname("Ershov")
                    .withLogin("petyaershov")
                    .withPassword("strongpassword15132")
                    .withGender(1)
                    .build();
            System.out.println(userDAO.add(user));
            System.out.println();
            System.out.println(userDAO.getAll());
            System.out.println("End");
//            int[] amounts = new int[]{1, 10, 100, 1000, 10000, 50000, 100000, 500000};
//            for (int i: amounts){
//                long m = System.currentTimeMillis();
//                insertManyUsers(userDAO, i);
//                System.out.print("Added " + i + " documents in ");
//                System.out.print((double) (System.currentTimeMillis() - m));
//                System.out.print(" milliseconds");
//            }
            System.out.println(userDAO.delete("g"));
        }catch (SQLException e){
            System.out.println("There was an error");
        }
    }

    public static void insertManyUsers(UserDAO userDAO, int amount) throws SQLException {
        List<User> users = new ArrayList<>();
        User user = new User.Builder()
                .withName("Petya")
                .withSurname("Ershov")
                .withLogin("petyaershov")
                .withPassword("strongpassword15132")
                .withGender(1)
                .build();
        for (int i = 0; i < amount; i++){
            user.setId("" + i);
            users.add(user);
        }
        userDAO.addAll(users);
    }
}
