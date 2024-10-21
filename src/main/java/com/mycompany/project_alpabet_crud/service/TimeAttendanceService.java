/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.TimeAttendanceDao;
import com.mycompany.project_alpabet_crud.model.TimeAttendance;
import java.util.List;


/**
 *
 * @author werapan
 */
public class TimeAttendanceService {

    public TimeAttendance getById(int id) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.get(id);
    }

    public List<TimeAttendance> getTimeAttendances() {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.getAll(" ta_date, user_id ASC");
    }

    public List<TimeAttendance> getTimeAttendanceById(int id) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.getAll("WHERE user_id = " + id, "ORDER BY ta_date ASC");
    }

    public List<TimeAttendance> getTimeAttendanceByDay(String bebin, String end) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.getAll(bebin, end, "ORDER BY ta_date ASC");
    }

    public TimeAttendance addNew(TimeAttendance editedTimeAttendance) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();

        timeAttendanceDao.save(editedTimeAttendance);

        return editedTimeAttendance;
    }

    public TimeAttendance update(TimeAttendance editedTimeAttendance) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.update(editedTimeAttendance);
    }

    public int delete(TimeAttendance editedTimeAttendance) {
        TimeAttendanceDao timeAttendanceDao = new TimeAttendanceDao();
        return timeAttendanceDao.delete(editedTimeAttendance);
    }

}
