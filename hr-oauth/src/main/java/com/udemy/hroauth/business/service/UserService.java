package com.udemy.hroauth.business.service;

import com.udemy.hroauth.view.exception.ResourceNotFoundException;
import com.udemy.hroauth.feign.UserFeignClient;
import com.udemy.hroauth.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {

    private UserFeignClient feignClient;

    @SneakyThrows
    public User getByEmail(String email) {
        User user = feignClient.getByEmail(email).getBody();
        if (user == null) {
            log.info("Could not find a user with email: " + email);
            throw new ResourceNotFoundException("user", "email", email);
        }

        log.info("Email found: " + email);
        return user;
    }
}
