package org.vikki;

public class WrongInputException extends RuntimeException {
    WrongInputException(String msg){
        super(msg);
    }
}
