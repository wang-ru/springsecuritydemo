package wr.security.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public class User {
    public interface SimpleUser {

    }

    public interface DetailUser extends SimpleUser {

    }

    private Integer id;
    private String userName;
    @NotBlank
    private String password;
    private Date birthday;
    @JsonView(SimpleUser.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonView(DetailUser.class)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @JsonView(SimpleUser.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }
    @JsonView(SimpleUser.class)
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
