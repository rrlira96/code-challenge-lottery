package com.rrlira96.codechallengelottery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "lottery_draws")
public class Draw {
    @Id
    @Column(name = "draw_number")
    private Integer drawNumber;
    private Integer product;
    @Column(name = "seq_number")
    private Integer seqNumber;
    @Column(name = "draw_date")
    private Date drawDate;
    @Column(name = "number_drawn_1")
    private Integer numberDrawn1;
    @Column(name = "number_drawn_2")
    private Integer numberDrawn2;
    @Column(name = "number_drawn_3")
    private Integer numberDrawn3;
    @Column(name = "number_drawn_4")
    private Integer numberDrawn4;
    @Column(name = "number_drawn_5")
    private Integer numberDrawn5;
    @Column(name = "number_drawn_6")
    private Integer numberDrawn6;
    @Column(name = "bonus_number")
    private Integer bonusNumber;

    public Draw() {
    }

    public Draw(Integer numberDrawn1, Integer numberDrawn2, Integer numberDrawn3, Integer numberDrawn4, Integer numberDrawn5, Integer numberDrawn6, Integer bonusNumber) {
        this.numberDrawn1 = numberDrawn1;
        this.numberDrawn2 = numberDrawn2;
        this.numberDrawn3 = numberDrawn3;
        this.numberDrawn4 = numberDrawn4;
        this.numberDrawn5 = numberDrawn5;
        this.numberDrawn6 = numberDrawn6;
        this.bonusNumber = bonusNumber;
    }

    public Integer getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(Integer drawNumber) {
        this.drawNumber = drawNumber;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public Integer getNumberDrawn1() {
        return numberDrawn1;
    }

    public void setNumberDrawn1(Integer numberDrawn1) {
        this.numberDrawn1 = numberDrawn1;
    }

    public Integer getNumberDrawn2() {
        return numberDrawn2;
    }

    public void setNumberDrawn2(Integer numberDrawn2) {
        this.numberDrawn2 = numberDrawn2;
    }

    public Integer getNumberDrawn3() {
        return numberDrawn3;
    }

    public void setNumberDrawn3(Integer numberDrawn3) {
        this.numberDrawn3 = numberDrawn3;
    }

    public Integer getNumberDrawn4() {
        return numberDrawn4;
    }

    public void setNumberDrawn4(Integer numberDrawn4) {
        this.numberDrawn4 = numberDrawn4;
    }

    public Integer getNumberDrawn5() {
        return numberDrawn5;
    }

    public void setNumberDrawn5(Integer numberDrawn5) {
        this.numberDrawn5 = numberDrawn5;
    }

    public Integer getNumberDrawn6() {
        return numberDrawn6;
    }

    public void setNumberDrawn6(Integer numberDrawn6) {
        this.numberDrawn6 = numberDrawn6;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
