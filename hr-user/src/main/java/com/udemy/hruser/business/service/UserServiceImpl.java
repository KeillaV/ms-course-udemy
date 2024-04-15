package com.udemy.hruser.business.service;

import com.udemy.hruser.model.entity.User;
import com.udemy.hruser.model.repository.UserRepository;
import com.udemy.hruser.view.exception.ResourceAlreadyExistsException;
import com.udemy.hruser.view.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    @SneakyThrows
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id.toString()));
    }

    @Override
    @SneakyThrows
    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("user", "email", email));
    }

    @Override
    @SneakyThrows
    public User save(User user) {
        if (repository.existsByEmail(user.getName())) {
            throw new ResourceAlreadyExistsException("user", "email", user.getEmail());
        }
        return repository.save(user);
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("user", "id", id.toString());
        }
        repository.deleteById(id);
    }
}
