package ua.nure.sdb.dao.MongoDB;

import com.mongodb.client.*;
import com.mongodb.MongoException;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import ua.nure.sdb.dao.UserDAO;
import ua.nure.sdb.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mongodb.client.MongoClient;

import static ua.nure.sdb.dao.MongoDB.MongoDBFactory.getMongoClient;


public class MongoDBUserDao extends UserDAO {
    @Override
    public List<User> get(String id) throws MongoException {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        List<Document> documents = new ArrayList<>();
        documents.add(collection.find(Filters.eq("id", id)).first());
        return mapUser(documents);
    }
    private List<User> mapUser(List<Document> documents) throws MongoException {
        List<User> users = new ArrayList<>();
        for (Document document: documents) {
            users.add(new User.Builder()
                    .withId(document.getString("id"))
                    .withName(document.getString("name"))
                    .withSurname(document.getString("surname"))
                    .withLogin(document.getString("login"))
                    .withPassword(document.getString("password"))
                    .withGender(document.getInteger("gender"))
                    .build());
        }
        return users;
    }
    @Override
    public List<User> getAll() throws MongoException {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        List<Document> documents = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            documents.add(document);
        }
        return mapUser(documents);
    }

    @Override
    public boolean add(User user) throws MongoException {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        collection.insertOne(mapDocument(user));
        return true;
    }

    @Override
    public boolean addAll(List<User> users) throws MongoException {
        MongoClient mongoClient = getMongoClient();
        MongoDatabase mongoDatabase = mongoClient.getDatabase("restaurant");
        MongoCollection<Document> collection = mongoDatabase.getCollection("user");
        List<Document> documents = new ArrayList<>();
        for(User user: users){
            documents.add(mapDocument(user));
        }
        collection.insertMany(documents);
        return true;
    }

    public Document mapDocument(User user){
        Document documentUser = new Document();
        documentUser.put("id", user.getId());
        documentUser.put("name", user.getName());
        documentUser.put("surname", user.getSurname());
        documentUser.put("login", user.getLogin());
        documentUser.put("password", user.getPassword());
        documentUser.put("gender", user.getGender());
        return documentUser;
    }

    @Override
    public boolean delete(String id) throws MongoException {
        return false;
    }
}
