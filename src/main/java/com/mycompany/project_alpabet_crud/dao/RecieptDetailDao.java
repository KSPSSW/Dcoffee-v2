/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.RecieptDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author werapan
 */
public class RecieptDetailDao implements Dao<RecieptDetail> {

    @Override
    public RecieptDetail get(int id) {
        RecieptDetail recieptDetail = null;
        String sql = "SELECT * FROM receiptDetail WHERE reciept_detail_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                recieptDetail = RecieptDetail.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return recieptDetail;
    }

    public List<RecieptDetail> getAll() {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<RecieptDetail> getAll(String where, String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<RecieptDetail> getAll(String order) {
        ArrayList<RecieptDetail> list = new ArrayList();
        String sql = "SELECT * FROM receipt_detail  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                RecieptDetail recieptDetail = RecieptDetail.fromRS(rs);
                list.add(recieptDetail);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public RecieptDetail save(RecieptDetail obj) {

        String sql = "INSERT INTO receipt_detail (product_id,product_name,product_price,qty,total_price,receipt_id,product_size,product_sweet_level,product_type)"
                + "VALUES(?, ?,?,?,?,?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setFloat(3,obj.getProductPrice());
            stmt.setInt(4,obj.getQty());
            stmt.setFloat(5,obj.getTotalPrice());
            stmt.setInt(6,obj.getRecieptId());
            stmt.setString(7, obj.getProductSize());
            stmt.setString(8, obj.getProductSweetLevel());
            stmt.setString(9, obj.getProductType());
//            System.out.println(stmt);
            stmt.executeUpdate();
            int id = DatabaseHelper.getInsertedId(stmt);
            obj.setId(id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return obj;
    }

    @Override
    public RecieptDetail update(RecieptDetail obj) {
        String sql = "UPDATE receiptDetail"
                + " SET product_id = ?, product_name = ?, product_price = ?, qty = ?, total_price = ?, receipt_id"
                + " WHERE receipt_detail_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1, obj.getProductId());
            stmt.setString(2, obj.getProductName());
            stmt.setFloat(3,obj.getProductPrice());
            stmt.setInt(4,obj.getQty());
            stmt.setFloat(5,obj.getTotalPrice());
            stmt.setInt(6,obj.getRecieptId());
            stmt.setInt(7,obj.getId());
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
    public int delete(RecieptDetail obj) {
        String sql = "DELETE FROM receipt_detail WHERE receipt_detail_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            int ret = stmt.executeUpdate();
            return ret;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;        
    }

}
