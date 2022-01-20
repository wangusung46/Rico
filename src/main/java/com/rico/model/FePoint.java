/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rico.model;

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
@Table(name = "fe_point")
public class FePoint {
    
    @Id
    private String id;
    private Integer value;
    private String member_citizenId;

    public FePoint() {
    }

    public FePoint(String id, Integer value, String member_citizenId) {
        this.id = id;
        this.value = value;
        this.member_citizenId = member_citizenId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMember_citizenId() {
        return member_citizenId;
    }

    public void setMember_citizenId(String member_citizenId) {
        this.member_citizenId = member_citizenId;
    }
    
}
