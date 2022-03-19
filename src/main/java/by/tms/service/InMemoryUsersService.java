package by.tms.service;

import by.tms.dao.inmemory.InMemoryUsersStorage;
import by.tms.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class InMemoryUsersService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    InMemoryUsersStorage inMemoryUsersStorage = InMemoryUsersStorage.getInstance();

    public boolean addUser(User user) {
        if (!inMemoryUsersStorage.checkOneByUserName(user.getLogin())) {
            inMemoryUsersStorage.addUser(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean checkByUserLogin(String userLogin) {
        return inMemoryUsersStorage.checkOneByUserName(userLogin);
    }

    public User getByUserId(int id) {
        return inMemoryUsersStorage.getById(id);
    }

    public boolean checkUserByUsernamePassword(String username, String password) {
        User user = inMemoryUsersStorage.getOneByUserName(username);
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public ArrayList<User> getUsers() {
        return inMemoryUsersStorage.getAll();
    }

    public void deleteUsers() {
        inMemoryUsersStorage.deleteAll();
    }
}
