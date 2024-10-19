/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.Material;
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
public class MaterialDao implements Dao<Material> {

        @Override
    public Material get(int id) {
        Material material = null;
        String sql = "SELECT * FROM material WHERE material_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                material = Material.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return material;
    }
    
    public Material getByUserImport(String user) {
        Material material = null;
        String sql = "SELECT * FROM material WHERE material_user_import=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                material = Material.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return material;
    }
    
    public Material getByName(String name) {
        Material material = null;
        String sql = "SELECT * FROM material WHERE material_name=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                material = Material.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return material;
    }

    public List<Material> getAll() {
        ArrayList<Material> list = new ArrayList();
        String sql = "SELECT * FROM material ";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Material> getAll(String where, String order) {
        ArrayList<Material> list = new ArrayList();
        String sql = " SELECT * FROM material where " + where + " ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Material> getAll(String order) {
        ArrayList<Material> list = new ArrayList();
        String sql = "SELECT * FROM material  ORDER BY " + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Material material = Material.fromRS(rs);
                list.add(material);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Material save(Material obj) {

        String sql = "INSERT INTO material (material_name, material_qty, material_total_price,material_price_perunit,material_shop_import)"
                + "VALUES(?, ?, ?,?,?,?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2, obj.getQty());
            stmt.setInt(3,obj.getTotalPrice());
            stmt.setInt(5,obj.getPricePerUnit());
            stmt.setString(6,obj.getShop());
            
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
    public Material update(Material obj) {
        String sql = "UPDATE material"
                + " SET material_qty = material_qty + ?, material_total_price = material_total_price + ?, material_price_perunit = (material_price_perunit + ?) / 2 , material_shop_import = ?"
                + " WHERE material_name = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getQty());
            stmt.setInt(2, obj.getTotalPrice());
            stmt.setInt(3, obj.getPricePerUnit());
            stmt.setString(4, obj.getShop());
            stmt.setString(5, obj.getName());
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
    public int delete(Material obj) {
        String sql = "DELETE FROM material WHERE material_id=?";
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
