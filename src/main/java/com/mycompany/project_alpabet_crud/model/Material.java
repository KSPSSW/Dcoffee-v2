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
public class Material {

    public static Material fromRS(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private int id;
    private String name;
    private int quantity;
    private String inDate;
    private String expireDate;
    private int stockId;

    public Material(int id, String name, int quantity, String inDate, String expireDate, int stockId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.inDate = inDate;
        this.expireDate = expireDate;
        this.stockId = stockId;
    }

    public Material(String name, int quantity, String inDate, String expireDate, int stockId) {
        this.id = -1;
        this.name = name;
        this.quantity = quantity;
        this.inDate = inDate;
        this.expireDate = expireDate;
        this.stockId = stockId;
    }

    public Material() {
        this.id = -1;
        this.name = "";
        this.quantity = 0;
        this.inDate = null;
        this.expireDate = null;
        this.stockId = -1;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    

    @Override
    public String toString() {
        return "Matererial{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", inDate=" + inDate + ", expireDate=" + expireDate + ", stockId=" + stockId + '}';
    }
    
    public static Material fromRs(ResultSet rs){
        Material material = new Material();
        try {
            material.setId(rs.getInt("mat_id"));
            material.setName(rs.getString("mat_name"));
            material.setQuantity(rs.getInt("mat_quantity"));
            material.setInDate(rs.getString("mat_inDate"));
            material.setExpireDate(rs.getString("mat_expireDate"));
            material.setId(rs.getInt("stockId"));
        } catch(SQLException ex){
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return material;
    }
}
     
