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
public class Material {

     public static Material fromRS(ResultSet rs) {
        Material material = new Material();
        try {
            material.setId(rs.getInt("material_id"));
            material.setName(rs.getString("material_name"));
            material.setQty(rs.getInt("material_qty"));
            material.setTotalPrice(rs.getInt("material_total_price"));
            material.setPricePerUnit(rs.getInt("material_price_perunit"));
            material.setShop(rs.getString("material_shop_import"));
        } catch(SQLException ex){
            Logger.getLogger(Material.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return material;
    }
    private int id;
    private String name;
    private int qty;
    private int totalprice;
    private int priceperunit;
    private String matshopimport;
    private int amount;

    public Material(int id, String name, int qty, int totalprice, int priceperunit, String matshopimport, int amount) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.totalprice = totalprice;
        this.priceperunit = priceperunit;
        this.matshopimport = matshopimport;
        this.amount = amount;
    }

    public Material(String name, int qty, int totalprice ,int priceperunit, String matshopimport, int amount) {
        this.id = -1;
        this.name = name;
        this.qty = qty;
        this.totalprice = totalprice;
        this.priceperunit=priceperunit;
        this.matshopimport=matshopimport;
        this.amount = amount;
    }

    public Material() {
        this.id = -1;
        this.name = "";
        this.qty = 0;
        this.totalprice = 0;
        this.priceperunit=0;
        this.matshopimport="";
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(int price) {
        this.totalprice = price;
    }

    public int getPricePerUnit() {
        return priceperunit;
    }

    public void setPricePerUnit(int priceperunit) {
        this.priceperunit = priceperunit;
    }
    public String getShop() {
        return matshopimport;
    }

    public void setShop(String matshopimport) {
        this.matshopimport = matshopimport;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", name=" + name + ", qty=" + qty + ", totalprice=" + totalprice + ", priceperunit=" + priceperunit + ", matshopimport=" + matshopimport + ", amount=" + amount + '}';
    }

    
    
}

