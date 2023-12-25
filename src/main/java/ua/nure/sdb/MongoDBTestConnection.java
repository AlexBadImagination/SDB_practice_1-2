package ua.nure.sdb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public class MongoDBTestConnection {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString(URL);
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        try {
            // Send a ping to confirm a successful connection
            //Bson command = new BsonDocument("ping", new BsonInt64(1));
            //Document commandResult = mongoDatabase.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            //System.err.println(me);
        }
    }



    /*public static String getURL() {
        FileInputStream fis;
        Properties property = new Properties();
        String host = null, login = null, password = null;
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);

            host = property.getProperty("mongodb.host");
            login = property.getProperty("mongodb.login");
            password = property.getProperty("mongodb.password");

        } catch (IOException e) {
            System.err.println("ERROR: there is no properties file!");
        }
        return host + "?sslMode=DISABLED&serverTimzone=UTC&user=" + login + "&password=" + password;
    }*/
    static final String URL = "mongodb://localhost:27017";
}
