/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rico.model;

import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rico
 */
@Entity
@Table(name = "fe_transaction")
public class FeTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date transDate;
    private BigInteger nominal;
    private String member_citizenId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public BigInteger getNominal() {
        return nominal;
    }

    public void setNominal(BigInteger nominal) {
        this.nominal = nominal;
    }

    public String getMember_citizenId() {
        return member_citizenId;
    }

    public void setMember_citizenId(String member_citizenId) {
        this.member_citizenId = member_citizenId;
    }

    public FeTransaction() {
    }

    public FeTransaction(Long id, Date transDate, BigInteger nominal, String member_citizenId) {
        this.id = id;
        this.transDate = transDate;
        this.nominal = nominal;
        this.member_citizenId = member_citizenId;
    }

}
