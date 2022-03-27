package by.tms.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {

    @NotEmpty(message = "login empty")
    private String login;

    @NotEmpty(message = "password empty")
    private String password;

    public UserDTO() {
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
