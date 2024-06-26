package com.udemy.hroauth.feign;

import com.udemy.hroauth.model.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    ResponseEntity<User> getByEmail(@RequestParam String email);
}
