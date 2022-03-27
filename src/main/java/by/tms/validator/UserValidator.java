package by.tms.validator;

import by.tms.dao.hibernate.HibernateUserDAO;
import by.tms.entity.UserDTO;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private HibernateUserDAO hibernateUserDAO;

    public boolean isValid(UserDTO userDTO) {
        return isValidUserName(userDTO) && isValidUserPassword(userDTO);
    }

    private boolean isValidUserName(UserDTO userDTO) {
        return hibernateUserDAO.findAllByName(userDTO.getLogin()).size() != 0;
    }

    private boolean isValidUserPassword(UserDTO userDTO) {
        User user = hibernateUserDAO.findByUsername(userDTO.getLogin());
        return user.getPassword().equals(userDTO.getPassword());
    }

}
