/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.CheckStockDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kissa
 */
public class CheckStockDetailDao implements Dao<CheckStockDetail> {

    @Override
    public CheckStockDetail get(int id) {
       CheckStockDetail checkStockDetail = null;
        String sql = "SELECT * FROM checkstock_detail WHERE crd_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkStockDetail = CheckStockDetail.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkStockDetail;
    }

    @Override
    public List<CheckStockDetail> getAll() {
        ArrayList<CheckStockDetail> list = new ArrayList();
        String sql = "SELECT * FROM stock_detail";
        Connection conn = DatabaseHelper.getConnect();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStockDetail checkStockDetail = CheckStockDetail.fromRS(rs);
                list.add(checkStockDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<CheckStockDetail> getAll(String where, String order) {
        ArrayList<CheckStockDetail> list = new ArrayList();
        String sql = "SELECT * FROM checkstock_detail WHERE " + where + " ORDER BY " + order;

        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStockDetail checkStockDetail = CheckStockDetail.fromRS(rs);
                list.add(checkStockDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<CheckStockDetail> getAll(String order) {
        ArrayList<CheckStockDetail> list = new ArrayList();
        String sql = "SELECT * FROM checkstock_detail ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStockDetail checkStockDetail = CheckStockDetail.fromRS(rs);
                list.add(checkStockDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public CheckStockDetail save(CheckStockDetail obj) {
        String sql = "INSERT INTO checkstock_detail (material_name, csd_qty, csd_unit_price, csd_amount, user_id, material_id)" + "VALUES(?,?,?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getQty());
            stmt.setFloat(3, obj.getUnitPrice());
            stmt.setInt(4, obj.getAmount());
            stmt.setInt(5, obj.getUserId());
            stmt.setInt(6, obj.getMaterialId());
            
                stmt.executeUpdate();
                int id = DatabaseHelper.getInsertedId(stmt);
                obj.setCsdId(id);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public CheckStockDetail update(CheckStockDetail obj) {
        String sql = "UPDATE checkstock_detail"
                    + " SET material_name = ?, csd_qty = ?, csd_unit_price = ?, csd_amount = ?,user_id = ?, material_id = ?"
                    + " WHERE csd_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getQty());
            stmt.setFloat(3, obj.getUnitPrice());
            stmt.setInt(4, obj.getAmount());
            stmt.setInt(5, obj.getUserId());
            stmt.setInt(6, obj.getMaterialId());
            
                stmt.executeUpdate();
                int id = DatabaseHelper.getInsertedId(stmt);
                obj.setCsdId(id);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
            }
        return null;
    }

    @Override
    public int delete(CheckStockDetail obj) {
        String sql = "DELETE FROM checkstock_detail WHERE csd_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCsdId());
            int ret = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }


}
