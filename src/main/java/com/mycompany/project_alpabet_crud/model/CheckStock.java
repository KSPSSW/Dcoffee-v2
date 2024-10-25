/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.model;

import com.mycompany.project_alpabet_crud.dao.UserDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kissa
 */
public class CheckStock {
    private int checkId;
    private Date checkDate;
    private String checkStatus;
    private int userId;
    private User user;
    private ArrayList<CheckStockDetail> checkStockDetails = new ArrayList<CheckStockDetail>();

    public CheckStock(int checkId, Date checkDate, String checkStatus, int userId) {
        this.checkId = checkId;
        this.checkDate = checkDate;
        this.checkStatus = checkStatus;
        this.userId = userId;
    }
    
    public CheckStock(int userId) {
        this.checkId = -1;
        this.checkDate = null;
        this.checkStatus = "";
        this.userId = userId;
    }
    
    public CheckStock(){
        this.checkId = -1;
        this.checkDate = null;
        this.checkStatus = "";
        this.userId = -1;
    }
    
    public CheckStock(User user) {
        this.checkId = -1;
        this.checkDate = null;
        this.checkStatus = "";
        this.userId = user.getId();
    }

    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<CheckStockDetail> getCheckStockDetails() {
        return checkStockDetails;
    }

    public void setCheckStockDetails(ArrayList<CheckStockDetail> checkStockDetails) {
        this.checkStockDetails = checkStockDetails;
    }
    
    public void addCheckStockDetail(CheckStockDetail checkStockDetail) {
        checkStockDetails.add(checkStockDetail);
    }
    
     public void addCheckStockDetail(Material Material, int qty, int unitPrice, int amount) {
        CheckStockDetail cd = new CheckStockDetail(Material.getName(),qty, unitPrice, qty - amount,-1, Material.getId());
        checkStockDetails.add(cd);
    }
     
    public void addCheckStockDetail(Material material, int qty) {
        CheckStockDetail cd = new CheckStockDetail();
        checkStockDetails.add(cd);
    }
        
    @Override
    public String toString() {
        return "CheckStock{" + "checkId=" + checkId + ", checkDate=" + checkDate + ", checkStatus=" + checkStatus + ", userId=" + userId + ", user=" + user + ", checkStockDetails=" + checkStockDetails + '}';
    }
    
    public static CheckStock fromRS(ResultSet rs) {
        CheckStock checkStock = new CheckStock();
        try {
            checkStock.setCheckId(rs.getInt("stock_id"));
            checkStock.setCheckDate(rs.getTimestamp("stock_date"));
            checkStock.setCheckStatus(rs.getString("stock_status"));
            checkStock.setUserId(rs.getInt("user_id"));

            //Population
            UserDao userDao = new UserDao();
            System.out.println(checkStock);
            System.out.println("checkStock Userid ="+checkStock.getUserId());
            User user = userDao.get(checkStock.getUserId());
            checkStock.setUser(user);

        } catch (SQLException ex) {
            Logger.getLogger(CheckStock.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return checkStock;
    }

    
    
    
}
