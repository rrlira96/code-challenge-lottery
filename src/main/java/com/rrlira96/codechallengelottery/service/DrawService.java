package com.rrlira96.codechallengelottery.service;

import com.rrlira96.codechallengelottery.entities.DateWon;
import com.rrlira96.codechallengelottery.entities.Draw;
import com.rrlira96.codechallengelottery.entities.DrawsReport;
import com.rrlira96.codechallengelottery.entities.UserGuess;
import com.rrlira96.codechallengelottery.repository.DrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DrawService {

    @Autowired
    private DrawRepository drawRepository;

    public static DrawsReport drawsReport = new DrawsReport();

    public DrawsReport generateReport(UserGuess userGuess) {
        List<Draw> draws = drawRepository.findAll();
        List<DateWon> datesWonList = new ArrayList<>();
        for (Draw draw : draws) {
            checkIfWon(userGuess, draw);
        }

        return drawsReport;
    }


    public void checkIfWon(UserGuess userGuess, Draw draw) {
        Set<Integer> drawNumbers = new HashSet<>(Arrays.asList(draw.getNumberDrawn1(), draw.getNumberDrawn2(),
                draw.getNumberDrawn3(), draw.getNumberDrawn4(), draw.getNumberDrawn5(), draw.getNumberDrawn6()));

        Set<Integer> matchedNumbers = drawNumbers.stream()
                .filter(x -> userGuess.getNumbers().contains(x))
                .collect(Collectors.toSet());

        boolean hasBonus = userGuess.getNumbers().contains(draw.getBonusNumber());
        Double prize;

        if (matchedNumbers.size() == 2) {
            if (hasBonus) {
                prize = 5.00;
                System.out.println("2/6+ - $ 5.00");
            } else {
                prize = 3.00;
                System.out.println("2/6 - $ 3.00");
            }
        } else if (matchedNumbers.size() == 3) {
            prize = 10.00;
            System.out.println("3/6 - $ 10.00");
        } else if (matchedNumbers.size() == 4) {
            prize = 85.00;
            System.out.println("4/6 - $ 85.00");
        } else if (matchedNumbers.size() == 5) {
            if (hasBonus) {
                prize = 250000.00;
                System.out.println("5/6+ - $ 250,000.00");
            } else {
                prize = 3000.00;
                System.out.println("5/6 - $ 3,000.00");
            }
        } else if (matchedNumbers.size() == 6) {
            prize = 5000000.00;
            System.out.println("6/6 - $ 5,000,000.00");
        } else {
            prize = 0.00;
            System.out.println("0/6 - $ 0.00");
        }

        if (prize > 0){
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
}
