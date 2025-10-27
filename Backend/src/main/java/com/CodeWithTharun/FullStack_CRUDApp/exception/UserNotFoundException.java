package com.CodeWithTharun.FullStack_CRUDApp.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(long id){
        super("Could not find the user with id : "+id);
    }
}
