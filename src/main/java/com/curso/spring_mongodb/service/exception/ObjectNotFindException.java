package com.curso.spring_mongodb.service.exception;

public class ObjectNotFindException extends RuntimeException{
    public ObjectNotFindException(String msg){
        super(msg);
    }
}
