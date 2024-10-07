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
 * @author kissa
 */
public class Stock {
    private int id;
    private String name;
    private int total;
    private int amount;

    public Stock(int id, String name, int total, int amount) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.amount = amount;
    }

    public Stock(String name, int total, int amount) {
        this.id = -1;
        this.name = name;
        this.total = total;
        this.amount = amount;
    }

    public Stock() {
        this.id = -1;
        this.name = "";
        this.total = 0;
        this.amount = 0;
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

    @Override
    public String toString() {
        return "Stock{" + "id=" + id + ", name=" + name + ", total=" + total + ", amount=" + amount + '}';
    }
    
    public static Stock fromRS(ResultSet rs) {
        Stock stock = new Stock();
        try {
            stock.setId(rs.getInt("stock_id"));
            stock.setName(rs.getString("stock_name"));
            stock.setTotal(rs.getInt("stock_total"));
            stock.setAmount(rs.getInt("stock_amount"));
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return stock;
    }
}
