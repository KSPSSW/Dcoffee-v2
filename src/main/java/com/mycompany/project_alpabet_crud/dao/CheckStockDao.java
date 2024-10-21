/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.CheckStock;
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
public class CheckStockDao implements Dao<CheckStock> {

    @Override
    public CheckStock get(int id) {
       
        CheckStock checkStock = null;
        String sql = "SELECT * FROM checkstock WHERE stock_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                checkStock = CheckStock.fromRS(rs);
                CheckStockDetailDao csd = new CheckStockDetailDao();
                ArrayList<CheckStockDetail> checkStockDetails = (ArrayList<CheckStockDetail>) csd.getAll("crm_id="+checkStock.getCheckId(),"crd_id");
                checkStock.setCheckStockDetails(checkStockDetails);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkStock;
       
    }

    @Override
    public List<CheckStock> getAll() {
        ArrayList<CheckStock> list = new ArrayList();
        String sql = "SELECT * FROM checkstock";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStock checkStock = CheckStock.fromRS(rs);
                list.add(checkStock);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public List<CheckStock> getAll(String order) {
        ArrayList<CheckStock> list = new ArrayList();
        String sql = "SELECT * FROM checkstock  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStock checkStock = CheckStock.fromRS(rs);
                list.add(checkStock);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public CheckStock save(CheckStock obj) {
        String sql = "INSERT INTO checkstock (user_id)"
                + "VALUES(?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getUserId());
//            System.out.println(stmt);
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setCheckId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public CheckStock update(CheckStock obj) {
        String sql = "UPDATE checkstock"
                + " SET stock_date = ?, stock_status = ?, user_id = ?"
                + " WHERE stock_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getCheckStatus());
            stmt.setInt(2, obj.getUserId());
            stmt.setInt(3, obj.getCheckId());
//            System.out.println(stmt);
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            return obj;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public int delete(CheckStock obj) {
       String sql = "DELETE FROM checkstock WHERE crm_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getCheckId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1; 
    }

    @Override
    public List<CheckStock> getAll(String where, String order) {
       ArrayList<CheckStock> list = new ArrayList();
        String sql = "SELECT * FROM checkstock WHERE " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                CheckStock checkStock = CheckStock.fromRS(rs);
                list.add(checkStock);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
}
