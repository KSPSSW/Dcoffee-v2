/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.MaterialUserImport;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author teeraphat
 */
public class MaterialUserImportDao {
    public List<MaterialUserImport> getAll() {
        ArrayList<MaterialUserImport> list = new ArrayList();
        String sql = "SELECT * FROM material_user_import ";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MaterialUserImport material = MaterialUserImport.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public List<MaterialUserImport> getAll(String where, String order) {
        ArrayList<MaterialUserImport> list = new ArrayList();
        String sql = " SELECT * FROM material_user_import where " + where + " ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MaterialUserImport material = MaterialUserImport.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<MaterialUserImport> getAll(String order) {
        ArrayList<MaterialUserImport> list = new ArrayList();
        String sql = "SELECT * FROM material_user_import  ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                MaterialUserImport material = MaterialUserImport.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public MaterialUserImport save(MaterialUserImport obj) {

        String sql = "INSERT INTO material_user_import (material_user_import_id, material_user_import_name, material_import_name)"
                + "VALUES(?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,obj.getUserId());
            stmt.setString(2,obj.getUserName());
            stmt.setString(3,obj.getMaterialName());
            
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }
}
