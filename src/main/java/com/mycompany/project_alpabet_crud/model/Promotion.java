/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Promotion {
    private int id;
    private String name;
    private String startDate;
    private String expireDate;
    private String status;

    public Promotion(int id, String name, String startDate, String expireDate, String status) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.status = status;
    }
    
    public Promotion(String name, String startDate, String expireDate, String status) {
        this.id = -1;
        this.name = name;
        this.startDate = startDate;
        this.expireDate = expireDate;
        this.status = status;
    }
    
    public Promotion(String name, String status) {
        this.id = -1;
        this.name = "";
        this.startDate = "";
        this.expireDate = "";
        this.status = "";
    }
    
    public Promotion() {
        this.id = -1;
        this.name = "";
        this.startDate = "";
        this.expireDate = "";
        this.status = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id=" + id + ", name=" + name + ", startDate=" + startDate + ", expireDate=" + expireDate + ", status=" + status + '}';
    }
    
    public static Promotion fromRS(ResultSet rs) {
        Promotion promotion = new Promotion();
        try {
            promotion.setId(rs.getInt("promotion_id"));
            promotion.setName(rs.getString("promotion_name"));
            promotion.setStartDate(rs.getString("promotion_startDate"));
            promotion.setExpireDate(rs.getString("promotion_expireDate"));
            promotion.setStatus(rs.getString("promotion_status"));
        } catch (SQLException ex) {
            Logger.getLogger(Promotion.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return promotion;
    }
}
