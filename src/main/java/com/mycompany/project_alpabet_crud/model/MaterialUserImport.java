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
 * @author teeraphat
 */
public class MaterialUserImport {

    public static MaterialUserImport fromRS(ResultSet rs) {
        MaterialUserImport MaterialUserImport = new MaterialUserImport();
        try {
            MaterialUserImport.setId(rs.getInt("material_import_id"));
            MaterialUserImport.setDate(rs.getTimestamp("material_import_date"));
            MaterialUserImport.setUserId(rs.getInt("material_user_import_id"));
            MaterialUserImport.setUserName(rs.getString("material_user_import_name"));
            MaterialUserImport.setMaterialName(rs.getString("material_import_name"));
            MaterialUserImport.setMaterialQty(rs.getInt("material_import_Qty"));
        } catch(SQLException ex){
            Logger.getLogger(MaterialUserImport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return MaterialUserImport;
    }
    private int id;
    private Date date;
    private int userId;
    private String userName;
    private String materialName;
    private int materialQty;

    public MaterialUserImport(int id,  Date date, int userId, String userName, String materialName,int materialQty) {
        this.id = id;
        this.date = date;
        this.userId = userId;
        this.userName = userName;
        this.materialName = materialName;
        this.materialQty = materialQty;
    }

    public MaterialUserImport(Date date, int userId, String userName ,String materialName,int materialQty) {
        this.id = -1;
        this.date = date;
        this.userId = userId;
        this.userName = userName;
        this.materialName = materialName;
        this.materialQty = materialQty;
    }

    public MaterialUserImport() {
        this.id = -1;
        this.date = null;
        this.userId = 0;
        this.userName = "";
        this.materialName = "";
        this.materialQty= 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

   public int getMaterialQty() {
        return materialQty;
    }

    public void setMaterialQty(int materialQty) {
        this.materialQty = materialQty;
    }

    @Override
    public String toString() {
        return "MaterialUserImport{" + "id=" + id + ", date=" + date + ", userId=" + userId + ", userName=" + userName + ", materialName=" + materialName + ", materialQty=" + materialQty + '}';
    }
    
}
