/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;


import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.Promotion;
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
public class PromotionDao implements Dao<Promotion> {

    @Override
    public Promotion get(int id) {
        Promotion promotion = null;
        String sql = "SELECT * FROM promotion WHERE promotion_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                promotion = Promotion.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return promotion;
    }

    public Promotion getByName(String name) {
        Promotion promotion = null;
        String sql = "SELECT * FROM promotion WHERE promotion_name=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                promotion = Promotion.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return promotion;
    }

    public List<Promotion> getAll() {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Promotion> getAll(String where, String order) {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Promotion> getAll(String order) {
        ArrayList<Promotion> list = new ArrayList();
        String sql = "SELECT * FROM promotion  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Promotion promotion = Promotion.fromRS(rs);
                list.add(promotion);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Promotion save(Promotion obj) {

        String sql = "INSERT INTO promotion (promotion_name, promotion_startDate, promotion_expireDate, promotion_status)"
                + "VALUES(?, ?, ?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getStartDate());
            stmt.setString(3, obj.getExpireDate());
            stmt.setString(4, obj.getStatus());
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
    public Promotion update(Promotion obj) {
        String sql = "UPDATE promotion"
                + " SET promotion_name, promotion_startDate, promotion_expireDate, promotion_status";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getStartDate());
            stmt.setString(3, obj.getExpireDate());
            stmt.setString(4, obj.getStatus());
            stmt.setInt(5, obj.getId());
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
    public int delete(Promotion obj) {
        String sql = "DELETE FROM promotion WHERE promotion_id=?";
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
