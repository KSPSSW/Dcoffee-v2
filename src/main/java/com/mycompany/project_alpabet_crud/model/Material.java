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
    private int qty;
    private int price;

    public Material(int id, String name, int qty, int price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Material(String name, int qty, int price) {
        this.id = -1;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public Material() {
        this.id = -1;
        this.name = "";
       this.qty = 0;
        this.price = 0;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + '}';
    }

    
    public static Material fromRs(ResultSet rs){
        Material material = new Material();
        try {
            material.setId(rs.getInt("material_id"));
            material.setName(rs.getString("material_name"));
            material.setQty(rs.getInt("material_qty"));
            material.setPrice(rs.getInt("material_price"));
        } catch(SQLException ex){
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return material;
    }
}

