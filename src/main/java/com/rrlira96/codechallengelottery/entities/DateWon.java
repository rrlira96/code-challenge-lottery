package com.rrlira96.codechallengelottery.entities;

import java.util.Date;

public class DateWon {
    private Date date;
    private Double prize;

    public DateWon(Date date, Double prize) {
        this.date = date;
        this.prize = prize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
