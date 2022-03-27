package com.adaschool.users.service;

import com.adaschool.users.data.User;
import com.adaschool.users.dto.UserDtoRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService{

        List<User> all();

        Optional<User> findById(String id );

        User create(UserDtoRequest user );

        User update( UserDtoRequest user, String userId );

        User deleteById( String id );
}