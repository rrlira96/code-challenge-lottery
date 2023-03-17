package com.rrlira96.codechallengelottery.service.exceptions;

public class InvalidRangeNumberException extends RuntimeException {
    public InvalidRangeNumberException(Integer number) {
        super("Invalid value '" + number + "'. Numbers are restricted between 1 and 49");
    }
}
