package com.design.ride.sharing.app.ridesharingapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.InputMismatchException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(InputMismatchException.class)
    public void handleInputMisMatchException(){
        throw new InputMismatchException("");
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(Inva)
//    public void handleInputMisMatchException(){
//        throw new InputMismatchException("The Given Input are not provided in the Requests");
//    }
}
