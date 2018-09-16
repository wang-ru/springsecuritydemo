package wr.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class SecurityApp
{
    public static void main(String[] args) {

        SpringApplication.run(SecurityApp.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "helloWorld";
    }
}
