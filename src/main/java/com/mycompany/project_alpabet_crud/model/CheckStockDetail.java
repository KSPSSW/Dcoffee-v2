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
public class CheckStockDetail {
    private int csdId;
    private String name;
    private int qty;
    private int unitPrice;
    private int amount;
    private int userId;
    private int materialId;

    public CheckStockDetail(int csdId, String name, int qty, int unitPrice, int amount, int userId, int materialId) {
        this.csdId = csdId;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.userId = userId;
        this.materialId = materialId;
    }

    public CheckStockDetail(String name, int qty, int unitPrice, int amount, int userId, int materialId) {
        this.csdId = -1;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.userId = userId;
        this.materialId = materialId;
    }

    public CheckStockDetail() {
        this.csdId = -1;
        this.name = "";
        this.qty = 0;
        this.unitPrice = 0;
        this.amount = 0;
        this.userId = 0;
        this.materialId = 0;
    }

    

    public int getCsdId() {
        return csdId;
    }

    public void setCsdId(int csdId) {
        this.csdId = csdId;
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

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    @Override
    public String toString() {
        return "CheckStockDetail{" + "csdId=" + csdId + ", name=" + name + ", qty=" + qty + ", unitPrice=" + unitPrice + ", amount=" + amount + ", userId=" + userId + ", materialId=" + materialId + '}';
    }
    
    public static CheckStockDetail fromRS(ResultSet rs){
        CheckStockDetail checkStockDetail = new CheckStockDetail();
        try {
            checkStockDetail.setCsdId(rs.getInt("csd_id"));
            checkStockDetail.setName(rs.getString("material_name"));
            checkStockDetail.setCsdId(rs.getInt("csd_qty"));
            checkStockDetail.setCsdId(rs.getInt("csd_unit_price"));
            checkStockDetail.setCsdId(rs.getInt("csd_amount"));
            checkStockDetail.setCsdId(rs.getInt("user_id"));
            checkStockDetail.setCsdId(rs.getInt("material_id"));
        } catch (SQLException ex){
            Logger.getLogger(CheckStock.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return checkStockDetail;
    }
        
    
    
}
