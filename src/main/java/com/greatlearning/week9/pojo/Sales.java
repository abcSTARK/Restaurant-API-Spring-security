package com.greatlearning.week9.pojo;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;



    private String billname;
    private int amount;

    public Sales() {
    }

    public Sales(String billname, int amount) {
        this.billname = billname;
        this.amount = amount;
    }

    public Sales(int uid, String billname, int amount) {
        this.uid = uid;
        this.billname = billname;
        this.amount = amount;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBillname() {
        return billname;
    }

    public void setBillname(String billname) {
        this.billname = billname;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
