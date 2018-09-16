package wr.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wr.security.dto.User;
import wr.security.dto.UserQueryCondition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @GetMapping("/user")
    @JsonView(User.SimpleUser.class)
    public List<User> getUser(UserQueryCondition userQueryCondition, @PageableDefault(size = 10,sort = "age,desc") Pageable pageable) {
        System.out.println("pageable:"+ReflectionToStringBuilder.toString(pageable));
        System.out.println("userQueryCondition:" + ReflectionToStringBuilder.toString(userQueryCondition));
        List<User> users = new ArrayList<>();
        users.add(new User());
        return users;
    }
    @GetMapping("/user/{id:\\d+}")
    @JsonView(User.DetailUser.class)
    public User getInfo(@PathVariable Integer id) {
        System.out.println("id:"+id);
        User u = new User();
        u.setUserName("tom");
        return u;
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(ReflectionToStringBuilder.toString(user));
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(e-> System.out.println(e.getDefaultMessage()));
        }
        user.setId(1);
        return user;
    }
}