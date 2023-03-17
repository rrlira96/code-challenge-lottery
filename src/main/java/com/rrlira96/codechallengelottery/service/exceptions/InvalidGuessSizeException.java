package com.rrlira96.codechallengelottery.service.exceptions;

public class InvalidGuessSizeException extends RuntimeException {
    public InvalidGuessSizeException() {
        super("Invalid guess, user must choose 6 unique numbers");
    }
}
