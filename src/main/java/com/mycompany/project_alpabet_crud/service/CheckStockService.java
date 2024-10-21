/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.CheckStockDao;
import com.mycompany.project_alpabet_crud.dao.CheckStockDetailDao;
import com.mycompany.project_alpabet_crud.model.CheckStock;
import com.mycompany.project_alpabet_crud.model.CheckStockDetail;
import java.util.List;

/**
 *
 * @author kissa
 */
public class CheckStockService {
    
     public CheckStock getById(int id) {
        CheckStockDao checkStockDao = new  CheckStockDao();
        return checkStockDao.get(id);
    }
     
     public List<CheckStock> getCheckStocks() {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.getAll(" stock_id ASC");
    }
     
     public CheckStock addNew(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        CheckStockDetailDao checkStockDetailDao = new CheckStockDetailDao();
        CheckStock checkStock = checkStockDao.save(editedCheckStock);
        
        System.out.println("in addNew");
        System.out.println(checkStock);
        System.out.println("----------------");
        
        for(CheckStockDetail rd: editedCheckStock.getCheckStockDetails()){
            rd.setCsdId(checkStock.getCheckId());
            checkStockDetailDao.save(rd);
        }
        return checkStock;
     }
     
     public CheckStock update(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.update(editedCheckStock);
    }
     
     public int delete(CheckStock editedCheckStock) {
        CheckStockDao checkStockDao = new CheckStockDao();
        return checkStockDao.delete(editedCheckStock);
    }
}
