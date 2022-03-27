package com.adaschool.users.service;

import com.adaschool.users.data.User;
import com.adaschool.users.dto.UserDtoRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class UserServiceHashMap implements IUserService {

    private final HashMap<String, User> userHashMap = new HashMap<>();

    @Override
    public List<User> all() {
        System.out.println("UserServiceHashMap - all()");
        Collection<User> values = userHashMap.values();
        List<User> usersList = new ArrayList<>(values);
        return usersList;
    }

    @Override
    public Optional<User> findById(String id) {
        System.out.println("UserServiceHashMap - findById(id)");
        User user = userHashMap.get(id);
        return user != null ? Optional.of(user) : Optional.empty();
    }

    @Override
    public User create(UserDtoRequest userDto) {
        System.out.println("UserServiceHashMap - create(id)");
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setCreatedAt(LocalDateTime.now());
        return userHashMap.put(user.getId().toString(), user);
    }

    @Override
    public User update(UserDtoRequest userDto, String userId) {
        System.out.println("UserServiceHashMap - update(id)");
        Optional<User> user =this.findById(userId);
        if (user.isPresent()){
            user.get().setName(userDto.getName());
            user.get().setLastName(userDto.getLastName());
            user.get().setEmail(userDto.getEmail());
            return userHashMap.put(userId, user.get());
        }
        return null;
    }

    @Override
    public User deleteById(String id) {
        System.out.println("UserServiceHashMap - deleteById(id)");
        Optional<User> user =this.findById(id);
        if (user.isPresent()){
            return userHashMap.remove(id);
        }
        return null;
    }
}
