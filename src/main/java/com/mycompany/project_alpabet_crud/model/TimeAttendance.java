/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.model;

import com.mycompany.project_alpabet_crud.dao.UserDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class TimeAttendance {

    private int id;
    private Date checkin;
    private Date checkout;
    private String type;
    private Date totalhours;
    private Date date;
    private String status;
    private int userId;
    private int workinghours;
    
    SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
    private String name;
    private int role;
    private String checkinTime;
    private String checkOutTime;
    private String dateTime;
    
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat sdfDate = new SimpleDateFormat( "yyyy-MM-dd" );

    public  String getdateTime(){
         return (checkin != null) ? sdfDate.format(date) : "Null";
        
    }
    public String getCheckinTime() {

        return (checkin != null) ? sdf.format(checkin) : "Null";
    }

    public String getCheckOutTime() {
            if (checkin != null && checkout != null) {
        return sdf.format(checkout);
    } else {
        return "";
    }

    }

    public TimeAttendance(int id, Date checkin, Date checkout, String type, Date totalhours, Date date, String status, int userId) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.type = type;
        this.totalhours = totalhours;
        this.date = date;
        this.status = status;
        this.userId = userId;
        calculateWorkingHours();
        this.checkinTime = (checkin != null) ? sdf.format(checkin) : "Null";
        this.checkOutTime = (checkout != null) ? sdf.format(checkout) : "Null";

    }

    public TimeAttendance(Date checkin, Date checkout, String type, Date totalhours, Date date, String status, int userId) {
        this.id = -1;
        this.checkin = checkin;
        this.checkout = checkout;
        this.type = type;
        this.totalhours = totalhours;
        this.date = date;
        this.status = status;
        this.userId = userId;
        calculateWorkingHours();
        this.checkinTime = (checkin != null) ? sdf.format(checkin) : "Null";
        this.checkOutTime = (checkout != null) ? sdf.format(checkout) : "Null";

    }

    public TimeAttendance(String type, int userId, int spId) {
        this.id = -1;
        this.checkin = checkin;
        this.checkout = checkin;
        this.type = type;
        this.totalhours = totalhours;
        this.date = date;
        this.status = status;
        this.userId = userId;
        this.workinghours = workinghours;
        this.checkinTime = (checkin != null) ? sdf.format(checkin) : "Null";
        this.checkOutTime = (checkout != null) ? sdf.format(checkout) : "Null";

    }

    public TimeAttendance() {
        this.id = -1;
        this.checkin = null;
        this.checkout = null;
        this.type = "";
        this.totalhours = null;
        this.date = null;
        this.status = "";
        this.userId = 0;
        this.workinghours = 0;
        this.checkinTime = (checkin != null) ? sdf.format(checkin) : "Null";
       this.checkOutTime = (checkout != null) ? sdf.format(checkout) : "Null";

    }

    private void calculateWorkingHours() {
        if (totalhours != null) {
            workinghours = Integer.parseInt(hourFormat.format(totalhours));
        } else {
            workinghours = 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setTotalhours(Date totalhours) {
        this.totalhours = totalhours;
        if (totalhours != null) {
            calculateWorkingHours();
        } else {
            workinghours = 0;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getChechin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotalhours() {
        return (totalhours != null) ? sdf.format(totalhours) : "";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public static Date parseSQLiteTimestamp(String timestamp) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.parse(timestamp);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String checkinTime = (checkin != null) ? sdf.format(checkin) : "Null";
        String checkoutTime = (checkout != null) ? sdf.format(checkout) : "Null";
        String totalhoursTime = (totalhours != null) ? sdf.format(totalhours) : "Null";

        return "TimeAttendance{" + "id=" + id + ", checkin=" + checkinTime + ", checkout=" + checkoutTime + ", type=" + type + ", totalhours=" + totalhoursTime + ", Working hours=" + workinghours + ", date=" + date + ", status=" + status + ", userId=" + userId + ", name=" + name + ", role=" + role + '}';
    }

    public static TimeAttendance fromRS(ResultSet rs) {
        TimeAttendance timeAttendance = new TimeAttendance();
        try {

            if (rs != null) {
                timeAttendance.setId(rs.getInt("ta_id"));

                String checkinValue = rs.getString("ta_checkin");
                if (checkinValue != null) {
                    Date checkinDate = parseSQLiteTimestamp(checkinValue);
                    timeAttendance.setCheckin(checkinDate);
                } else {
                    timeAttendance.setCheckin(null);
                }

                String checkoutValue = rs.getString("ta_checkout");
                if (checkoutValue != null && !checkoutValue.isEmpty()) {
                    Date checkoutDate = parseSQLiteTimestamp(checkoutValue);
                    timeAttendance.setCheckout(checkoutDate);
                } else {
                    timeAttendance.setCheckout(null);
                }

                String totalhoursValue = rs.getString("totalhours");
                if (checkoutValue != null) {
                    Date totalhours = parseSQLiteTimestamp(totalhoursValue);
                    timeAttendance.setTotalhours(totalhours);
                } else {
                    timeAttendance.setTotalhours(null);
                }

                timeAttendance.setId(rs.getInt("ta_id"));
                timeAttendance.setType(rs.getString("ta_type"));
                String dateStr = rs.getString("ta_date");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if (dateStr != null) {
                    try {
                        Date date = sdf.parse(dateStr);
                        timeAttendance.setDate(date);
                    } catch (ParseException e) {

                    }
                } else {
                    timeAttendance.setDate(null);
                }

                timeAttendance.setId(rs.getInt("ta_id"));
                timeAttendance.setType(rs.getString("ta_type"));
                timeAttendance.setStatus(rs.getString("ta_status"));
                timeAttendance.setUserId(rs.getInt("user_id"));


                UserDao userDao = new UserDao();
                User user = userDao.get(timeAttendance.getUserId());
                String name = user.getName();
                timeAttendance.setName(name);
                int role = user.getRole();
                timeAttendance.setRole(role);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TimeAttendance.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(TimeAttendance.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return timeAttendance;
    }

}
