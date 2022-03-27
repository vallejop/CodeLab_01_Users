package com.adaschool.users.service

public interface IUserService{

        User create( User user );

        User findById( String id );

        List<User> all();

        void deleteById( String id );

        User update( User user, String userId );
}