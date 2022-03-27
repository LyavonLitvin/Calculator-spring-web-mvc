package by.tms.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NotBlank // " " true
//    @NotEmpty //"    " false
    //	@Pattern()
//	@Max(45)
//	@Range(min = 3, max = 15)
//	@Size()
//	@Email(regexp = "")
    @NotBlank(message = Constants.MSG_ERROR_LOGIN_IS_BLANK)
    @NotEmpty(message = Constants.MSG_ERROR_LOGIN_IS_EMPTY)
    private String login;
    @NotBlank(message = Constants.MSG_ERROR_PASSWORD_IS_BLANK)
    @NotEmpty(message = Constants.MSG_ERROR_PASSWORD_IS_EMPTY)
    private String password;
    @NotBlank(message = Constants.MSG_ERROR_EMAIL_IS_BLANK)
    @NotEmpty(message = Constants.MSG_ERROR_EMAIL_IS_EMPTY)
    private String email;
//    @NotBlank(message = Constants.MSG_ERROR_SECRET_QUESTION_IS_BLANK)
//    @NotEmpty(message = Constants.MSG_ERROR_SECRET_QUESTION_IS_EMPTY)
//    private String secretQuestion;
//    private Timestamp userUpdateDate;
    //   private String sessionID;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Result> resultList;

    public User() {
    }

    public User(long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


