/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kissa
 */
public class Stock {
    private int id;
    private String matName;
    private int total;
    private int amount;
    private Date date;
    private int userId;
    private User user;

    public Stock(int id, String matName, int total, int amount, Date date, int userId) {
        this.id = id;
        this.matName = matName;
        this.total = total;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    public Stock(String matName, int total, int amount, Date date, int userId) {
        this.matName = matName;
        this.total = total;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    public Stock() {
        this.id = -1;
        this.matName = "";
        this.total = 0;
        this.amount = 0;
        this.date = null;
        this.userId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatName() {
        return matName;
    }

    public void setMatName(String matName) {
        this.matName = matName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getuserId(){
        return userId;
    }

    public void setuserId(int userInt){
        this.userId = userId;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
        this.userId = user.getId();
    }

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", matName=" + matName + ", total=" + total + ", amount=" + amount + ", date=" + date + ", userId=" + userId + ", user=" + user + '}';
    }

    
    
    
     public static Stock fromRS(ResultSet rs) {
        Stock stock = new Stock();
        try {
            stock.setId(rs.getInt("stock_id"));
            stock.setMatName(rs.getString("mat_name"));
            stock.setTotal(rs.getInt("stock_total"));
            stock.setAmount(rs.getInt("stock_amount"));
            stock.setDate(rs.getTimestamp("stock_date"));
            stock.setuserId(rs.getInt("user_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return stock;
    }
}
   