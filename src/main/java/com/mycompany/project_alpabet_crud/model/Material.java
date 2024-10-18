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
            material.setUser(rs.getString("material_user_import"));
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
    private String user;
    private int priceperunit;
    private String matshopimport;

    public Material(int id, String name, int qty, int totalprice, int priceperunit, String matshopimport) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.totalprice = totalprice;
        this.priceperunit = priceperunit;
        this.matshopimport = matshopimport;
    }

    public Material(String name, int qty, int totalprice ,int priceperunit, String matshopimport, String user) {
        this.id = -1;
        this.name = name;
        this.qty = qty;
        this.totalprice = totalprice;
        this.priceperunit=priceperunit;
        this.matshopimport=matshopimport;
        this.user =user;
    }

    public Material() {
        this.id = -1;
        this.name = "";
        this.qty = 0;
        this.totalprice = 0;
        this.priceperunit=0;
        this.matshopimport="";
        this.user="";
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
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", name=" + name + ", qty=" + qty + ", totalprice=" + totalprice + ", user=" + user + ", priceperunit=" + priceperunit + ", matshopimport=" + matshopimport + '}';
    }

    public void setShop(String matshopimport) {
        this.matshopimport = matshopimport;
    }
}

