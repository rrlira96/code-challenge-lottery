package com.rrlira96.codechallengelottery.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DrawsReport {

    @JsonProperty("dates_won")
    private List<DateWon> datesWonList = new ArrayList<>();
    @JsonProperty("total_won")
    private Double totalWon = 0.0;
    @JsonProperty("total_spent")
    private Double totalSpent = 0.0;
    @JsonProperty("net_won_loss")
    private Double netWinLoss = 0.0;

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
