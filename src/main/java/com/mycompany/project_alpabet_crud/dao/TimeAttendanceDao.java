/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.dao;

import com.mycompany.project_alpabet_crud.helper.DatabaseHelper;
import com.mycompany.project_alpabet_crud.model.TimeAttendance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tauru
 */
public class TimeAttendanceDao implements Dao<TimeAttendance> {

    @Override
    public TimeAttendance get(int id) {
        TimeAttendance timeAttendance = null;
        String sql = """
                     SELECT ta_id,
                            ta_checkin,
                            ta_checkout,
                            strftime('%H:%M:%S', strftime('%s', ta_checkout) - strftime('%s', ta_checkin), 'unixepoch') AS totalhours,
                            ta_date,
                            user_id
                     FROM time_attendance
                     WHERE ta_id= ?;""";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                timeAttendance = TimeAttendance.fromRS(rs);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return timeAttendance;
    }

    @Override
    public List<TimeAttendance> getAll() {
        ArrayList<TimeAttendance> list = new ArrayList();
        String sql = """
                     SELECT ta_id,
                            ta_checkin,
                            ta_checkout,
                            strftime('%H:%M:%S', strftime('%s', ta_checkout) - strftime('%s', ta_checkin), 'unixepoch') AS totalhours,
                            ta_date,
                            user_id
                     FROM time_attendance
                     """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TimeAttendance timeAttendance = TimeAttendance.fromRS(rs);
                list.add(timeAttendance);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public TimeAttendance save(TimeAttendance obj) {
        String sql = "INSERT INTO time_attendance (user_id, ta_checkin) VALUES (?, ?)";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getUserId());
            stmt.setString(2, obj.getCheckinTime());
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
    public TimeAttendance update(TimeAttendance obj) {
        String sql = "UPDATE time_attendance\n"
                + "SET ta_checkout = (time('now', 'Localtime'))\n"
                + "WHERE ta_id = ? ;";
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
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
    public int delete(TimeAttendance obj) {
        String sql = "DELETE FROM time_attendance WHERE ta_id=?";
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


    @Override
    public List<TimeAttendance> getAll(String where, String order) {
        ArrayList<TimeAttendance> list = new ArrayList<>();
        String sql = """
             SELECT ta_id,
                    ta_checkin,
                    ta_checkout,
                    strftime('%H:%M:%S', strftime('%s', ta_checkout) - strftime('%s', ta_checkin), 'unixepoch') AS totalhours,
                    ta_date,
                    user_id
             FROM time_attendance"""
                + " " + where + " " + order;

        Connection conn = DatabaseHelper.getConnect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                TimeAttendance timeAttendance = TimeAttendance.fromRS(rs);
                list.add(timeAttendance);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

  public List<TimeAttendance> getAll(String begin, String end, String order) {
    ArrayList<TimeAttendance> list = new ArrayList<>();
    String sql = """
        SELECT ta_id,
               ta_checkin,
               ta_checkout,
               strftime('%H:%M:%S', strftime('%s', ta_checkout) - strftime('%s', ta_checkin), 'unixepoch') AS totalhours,
               ta_date,
               user_id
        FROM time_attendance
        WHERE ta_date BETWEEN ? AND ?
        """ + order;
Connection conn = DatabaseHelper.getConnect();
    try {
         PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, begin);
        stmt.setString(2, end);
         ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TimeAttendance timeAttendance = TimeAttendance.fromRS(rs);
            list.add(timeAttendance);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return list;
}



    public List<TimeAttendance> getAll(String order) {
        ArrayList<TimeAttendance> list = new ArrayList<>();
        Connection conn = DatabaseHelper.getConnect();

        if (conn != null) {
            try {
                String sql = """
            SELECT ta_id,
                ta_checkin,
                ta_checkout,
                strftime('%H:%M:%S', strftime('%s', ta_checkout) - strftime('%s', ta_checkin), 'unixepoch') AS totalhours,
                ta_date,
                user_id
            FROM time_attendance 
            ORDER BY """ + order;

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    TimeAttendance timeAttendance = TimeAttendance.fromRS(rs);

                    if (rs.wasNull()) {
                        timeAttendance.setCheckout(null);
                    }

                    list.add(timeAttendance);
                }

            } catch (SQLException ex) {
                System.out.println("SQL Error: " + ex.getMessage());
            }
        } else {
            System.out.println("Connection Error: Unable to connect to the database.");
        }

        return list;
    }

}
