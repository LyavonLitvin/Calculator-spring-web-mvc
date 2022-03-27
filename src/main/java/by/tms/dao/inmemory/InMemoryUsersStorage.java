package by.tms.dao.inmemory;

import by.tms.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InMemoryUsersStorage {

//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    private static InMemoryUsersStorage instance;
//
//    private InMemoryUsersStorage() {
//    }
//
//    private final static ArrayList<User> users = new ArrayList<>();
//
//    {
//        users.add(new User(1, 1, "komot", "komot", "komot", "komot@mail.ru", "komot"));
//    }
//
//    public static InMemoryUsersStorage getInstance() {
//        if (instance == null) {
//            instance = new InMemoryUsersStorage();
//        }
//        return instance;
//    }
//
//
//    public void addUser(User user) {
//        logger.info("add user");
//        user.setIdUser(users.size() + 1);
//        users.add(user);
//    }
//
//    public User getOneByUserName(String login) {
//        logger.info("return one by login");
//        for (User user : users) {
//            if (user.getLogin().equals(login)) {
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public User getById(int id) {
//        return users.stream().filter(user -> user.getIdUser() == id).findAny().orElse(null);
//    }
//
//    public boolean checkOneByUserName(String login) {
//        logger.info("check one by login");
//        for (User user : users) {
//            if (user.getLogin().equals(login)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public ArrayList<User> getAll() {
//        logger.info("Return all users");
//        return users;
//    }
//
//    public void deleteAll() {
//        users.clear();
//        logger.info("Delete all users");
//    }
}
