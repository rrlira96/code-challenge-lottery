package com.rrlira96.codechallengelottery.entities;

import java.util.List;

public class DrawsReport {

    private List<DateWon> datesWonList;
    private Double totalWon;
    private Double totalSpent;
    private Double netWinLoss;

    public DrawsReport() {
    }

    public DrawsReport(List<DateWon> datesWonList, Double totalWon, Double totalSpent, Double netWinLoss) {
        this.datesWonList = datesWonList;
        this.totalWon = totalWon;
        this.totalSpent = totalSpent;
        this.netWinLoss = netWinLoss;
    }

    public List<DateWon> getDatesWonList() {
        return datesWonList;
    }

    public void setDatesWonList(List<DateWon> datesWonList) {
        this.datesWonList = datesWonList;
    }

    public Double getTotalWon() {
        return totalWon;
    }

    public void setTotalWon(Double totalWon) {
        this.totalWon = totalWon;
    }

    public Double getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Double getNetWinLoss() {
        return netWinLoss;
    }

    public void setNetWinLoss(Double netWinLoss) {
        this.netWinLoss = netWinLoss;
    }
}
