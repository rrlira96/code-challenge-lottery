package com.rrlira96.codechallengelottery.entities;

import java.util.Set;

public class UserGuess {
    private Set<Integer> numbers;

    public UserGuess() {
    }

    public UserGuess(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Draw{" +
                "drawNumbers=" + numbers +
                '}';
    }
}
