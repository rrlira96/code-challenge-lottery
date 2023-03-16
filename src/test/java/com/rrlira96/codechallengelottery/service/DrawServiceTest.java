package com.rrlira96.codechallengelottery.service;

import com.rrlira96.codechallengelottery.entities.Draw;
import com.rrlira96.codechallengelottery.entities.UserGuess;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;

@ExtendWith(MockitoExtension.class)
class DrawServiceTest {

    @InjectMocks
    private DrawService drawService;

    @Test
    void checkIfWon() {
        UserGuess userGuess = new UserGuess(new HashSet<>(Arrays.asList(8, 17, 12, 32, 55, 3)));
        Draw draw = new Draw(45, 17, 8, 9, 10, 11, 55);

        drawService.checkIfWon(userGuess, draw);
    }
}