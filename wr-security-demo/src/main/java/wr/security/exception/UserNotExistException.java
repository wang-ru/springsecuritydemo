package wr.security.exception;

public class UserNotExistException extends RuntimeException {
    private Integer id;

    public UserNotExistException(Integer id) {
        super("user not exist");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
