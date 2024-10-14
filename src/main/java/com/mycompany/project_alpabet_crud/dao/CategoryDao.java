/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;
import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.Category;
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
public class CategoryDao implements Dao<Category> {

    @Override
    public Category get(int id) {
        Category category = null;
        String sql = "SELECT * FROM category WHERE category_id=?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                category = Category.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return category;
    }


    public List<Category> getAll() {
        ArrayList<Category> list = new ArrayList();
        String sql = "SELECT * FROM category";
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Category category = Category.fromRS(rs);
                list.add(category);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<Category> getAll(String where, String order) {
        ArrayList<Category> list = new ArrayList();
        String sql = "SELECT * FROM category where " + where + " ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Category category = Category.fromRS(rs);
                list.add(category);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    

    public List<Category> getAll(String order) {
        ArrayList<Category> list = new ArrayList();
        String sql = "SELECT * FROM category  ORDER BY" + order;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Category category = Category.fromRS(rs);
                list.add(category);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Category save(Category obj) {

        String sql = "INSERT INTO category (category_name)"
                + "VALUES(?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());

            
            

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
    public Category update(Category obj) {
        String sql = "UPDATE category"
                + " SET category_name = ?"
                + " WHERE category_id = ?";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, obj.getName());
            stmt.setInt(2,obj.getId());
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
    public int delete(Category obj) {
        String sql = "DELETE FROM category WHERE category_id=?";
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
