/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_alpabet_crud.service;

import com.mycompany.project_alpabet_crud.dao.StockDao;
import com.mycompany.project_alpabet_crud.model.Stock;
import java.util.List;

/**
 *
 * @author kissa
 */
public class StockService {
    
    public Stock getByName(String tel) {
        StockDao stockDao = new StockDao();
        Stock stock = stockDao.getByName(tel);
        return stock;
    }
    
    public List<Stock> getStock(){
        StockDao stockDao = new StockDao();
        return stockDao.getAll(" stock_id asc");
    }
    
    public Stock addNew(Stock editedStock) {
        StockDao stockDao = new StockDao();
        return stockDao.save(editedStock);
    }

    public Stock update(Stock editedStock) {
        StockDao customerDao = new StockDao();
        return customerDao.update(editedStock);
    }

    public int delete(Stock editedStock) {
        StockDao stockDao = new StockDao();
        return stockDao.delete(editedStock);
    }
}
