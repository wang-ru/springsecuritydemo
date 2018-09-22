package wr.security.web.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wr.security.exception.UserNotExistException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotExistExceptionHandler(UserNotExistException u) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", u.getId());
        map.put("msg", u.getMessage());
        return map;
    }
}
