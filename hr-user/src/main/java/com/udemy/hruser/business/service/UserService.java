package com.udemy.hruser.business.service;

import com.udemy.hruser.model.entity.User;

public interface UserService {

    public User getById(Long id);
    public User getByEmail(String email);
    public User save(User user);
    public void delete(Long id);
}
