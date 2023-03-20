package com.rrlira96.codechallengelottery.service;

import com.rrlira96.codechallengelottery.entities.DateWon;
import com.rrlira96.codechallengelottery.entities.Draw;
import com.rrlira96.codechallengelottery.entities.DrawsReport;
import com.rrlira96.codechallengelottery.repository.DrawRepository;
import com.rrlira96.codechallengelottery.service.exceptions.InvalidGuessSizeException;
import com.rrlira96.codechallengelottery.service.exceptions.InvalidRangeNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DrawService {

    @Autowired
    private DrawRepository drawRepository;

    public DrawsReport drawsReport;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 49;

    public DrawsReport generateReport(Set<Integer> userGuess) {
        List<Draw> draws = drawRepository.findAllBySeqNum();
        drawsReport = new DrawsReport();
        for (Draw draw : draws) {
            checkIfWon(userGuess, draw);
        }

        drawsReport.setNetWinLoss(calculateNetWinLoss());

        return drawsReport;
    }


    public void checkIfWon(Set<Integer> userGuess, Draw draw) {
        Set<Integer> drawNumbers = new HashSet<>(Arrays.asList(draw.getNumberDrawn1(), draw.getNumberDrawn2(),
                draw.getNumberDrawn3(), draw.getNumberDrawn4(), draw.getNumberDrawn5(), draw.getNumberDrawn6()));

        Set<Integer> matchedNumbers = drawNumbers.stream()
                .filter(userGuess::contains)
                .collect(Collectors.toSet());

        boolean hasBonus = userGuess.contains(draw.getBonusNumber());
        Double prize;

        switch (matchedNumbers.size()) {
            case 2:
                prize = hasBonus ? 5.00 : 3.00;
                break;
            case 3:
                prize = 10.00;
                break;
            case 4:
                prize = 85.00;
                break;
            case 5:
                prize = hasBonus ? 250000.00 : 3000.00;
                break;
            case 6:
                prize = 5000000.00;
                break;
            default:
                prize = 0.00;
                break;
        }

        if (prize > 0) {
            drawsReport.setTotalWon(drawsReport.getTotalWon() + prize);
        }

        if (prize >= 85.00) {
            reportDate(draw.getDrawDate(), prize);
        }

        Double spent = calculateSpent(draw.getDrawNumber());
        drawsReport.setTotalSpent(drawsReport.getTotalSpent() + spent);
    }

    private Double calculateSpent(Integer drawNumber) {
        if (drawNumber <= 2124) {
            return 1.00;
        } else if (drawNumber <= 2989) {
            return 2.00;
        } else {
            return 3.00;
        }
    }

    private void reportDate(Date drawDate, Double prize) {
        DateWon dateWon = new DateWon(drawDate, prize);
        drawsReport.getDatesWonList().add(dateWon);
    }

    private Double calculateNetWinLoss() {
        return Math.abs(drawsReport.getTotalSpent() - drawsReport.getTotalWon());
    }

    public void validateUserGuess(Set<Integer> userGuess) {
        if (userGuess.size() != 6) {
            throw new InvalidGuessSizeException();
        }
        for (Integer guess : userGuess) {
            if (guess < MIN_VALUE || guess > MAX_VALUE) {
                throw new InvalidRangeNumberException(guess);
            }
        }
    }
}
