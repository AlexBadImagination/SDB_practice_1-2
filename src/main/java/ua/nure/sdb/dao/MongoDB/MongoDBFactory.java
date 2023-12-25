package ua.nure.sdb.dao.MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import ua.nure.sdb.dao.*;

public class MongoDBFactory extends DAOFactory {
    private UserDAO userDAO;
    private OrderDAO orderDAO;
    private DishDAO dishDAO;
    @Override
    public UserDAO getUserDAO() {
        if (userDAO == null) {
            userDAO = new MongoDBUserDao();
        }
        return userDAO;
    }

    @Override
    public OrderDAO getOrderDAO() {
        return null;
    }

    @Override
    public DishDAO getDishDAO() {
        return null;
    }

    @Override
    public OrderDishesDAO getOrderDishesDAO() {
        return null;
    }

    static final String URL = "mongodb://localhost:27017";

    static MongoClient getMongoClient(){
        ConnectionString connectionString = new ConnectionString(URL);
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        try {
            // Send a ping to confirm a successful connection
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = mongoDatabase.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            //System.err.println(me);
        }
        return mongoClient;
    }
}
